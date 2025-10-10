package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class AdminController {

    public AdminController() {
        log.info("No arg const of AdminController");
    }

    @Autowired
    AdminService adminService;

    @RequestMapping("/send-otp")
    public ModelAndView sendOTP(ModelAndView modelAndView, String email) {
        boolean result = adminService.sendOTP(email);
        if (result) {
            modelAndView.addObject("email", email);
            modelAndView.addObject("showotpField", result);
            modelAndView.setViewName("AdminLogin");
        } else {
            modelAndView.addObject("error", "Email not found");
            modelAndView.addObject("showotpField", "");
            modelAndView.setViewName("AdminLogin");
        }
        return modelAndView;
    }

    @RequestMapping("/verify-otp")
    public ModelAndView verifyOTP(ModelAndView modelAndView, String otp, String email, HttpSession session) {
        log.info("Verifying OTP for email: {}", email);
        boolean result = adminService.verifyOTP(otp);
        if (result) {
            session.setAttribute("adminEmail", email);
            modelAndView.addObject("success", "Login Successful");
            modelAndView.setViewName("Admin");
        } else {
            modelAndView.addObject("email", email);
            modelAndView.addObject("showotpField", result);
            modelAndView.addObject("error", "OTP is wrong");
            modelAndView.setViewName("AdminLogin");
        }
        return modelAndView;
    }

    @RequestMapping("/openDoctorRegisterPage")
    public ModelAndView openDoctorRegistrationPage(ModelAndView modelAndView) {
        log.info("Opening doctor registration page");
        List<String> specializations = adminService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("RegisterDoctor");
        return modelAndView;
    }

    @RequestMapping("/openSlot")
    public ModelAndView openSlotsPage(ModelAndView modelAndView) {
        List<String> specializations = adminService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("Slots");
        return modelAndView;
    }

    @PostMapping("/registerDoctor")
    public ModelAndView registerDoctor(@RequestParam("image") MultipartFile multipartFile, @Valid DoctorRegistrationDTO doctorRegistrationDTO, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {

        List<String> specializations = adminService.getAllSpecializations();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                log.info(error.getDefaultMessage());
                modelAndView.addObject("error", error.getDefaultMessage());
                modelAndView.addObject("specializations", specializations);
                modelAndView.addObject("values", doctorRegistrationDTO);
                modelAndView.setViewName("RegisterDoctor");
            }
        } else if (multipartFile.isEmpty()) {
            modelAndView.addObject("error", "Please upload the image");
            modelAndView.addObject("specializations", specializations);
            modelAndView.addObject("values", doctorRegistrationDTO);
            modelAndView.setViewName("RegisterDoctor");
        } else {
            boolean registered = adminService.registerDoctor(doctorRegistrationDTO, multipartFile);
            if (registered) {
                modelAndView.addObject("success", "Doctor registered successfully");
                modelAndView.setViewName("Admin");
            } else {
                modelAndView.addObject("error", "Failed to register doctor");
                modelAndView.addObject("specializations", specializations);
                modelAndView.addObject("values", doctorRegistrationDTO);
                modelAndView.setViewName("RegisterDoctor");
            }
        }
        return modelAndView;
    }

    @PostMapping("/saveSlot")
    public ModelAndView saveSlotTimings(@Valid SlotTimeDTO slotTimeDTO, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            List<String> specializations = adminService.getAllSpecializations();
            for (ObjectError error : errors) {
                log.info(error.getDefaultMessage());
                modelAndView.addObject("specializations", specializations);
                modelAndView.addObject("error", error.getDefaultMessage());
                modelAndView.setViewName("SetSlot");
            }
        }
        LocalTime startTime = LocalTime.parse(slotTimeDTO.getSlotStartTime());
        LocalTime endTime = LocalTime.parse(slotTimeDTO.getSlotEndTime());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        slotTimeDTO.setSlotStartTime(startTime.format(formatter));
        slotTimeDTO.setSlotEndTime(endTime.format(formatter));
        adminService.saveSlotTime(slotTimeDTO);
        List<String> specializations = adminService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.addObject("success", "Slot timings saved successfully");
        modelAndView.setViewName("Slots");
        return modelAndView;
    }

    @GetMapping("/getBySpecialization")
    public ModelAndView showDoctorSlotForm(@RequestParam String specialization, ModelAndView modelAndView) {
        List<String> specializations = adminService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        List<DoctorRegistrationDTO> doctorRegistrationDTOList = adminService.getDoctorDtoBySpecialization(specialization);
        List<String> slotTimings = adminService.getAllSlotsBySpecialization(specialization);
        if (doctorRegistrationDTOList.isEmpty()) {
            modelAndView.addObject("openDoctorSlotForm", "");
            modelAndView.addObject("error", "Slots already allocated");
        } else {
            modelAndView.addObject("specialization", specialization);
            modelAndView.addObject("slotTimings", slotTimings);
            modelAndView.addObject("openDoctorSlotForm", "found Doctor's");
            modelAndView.addObject("doctorRegistrationDTOList", doctorRegistrationDTOList);
        }

        modelAndView.setViewName("Slots");
        return modelAndView;
    }

    @PostMapping("/setSpecialization")
    public ModelAndView addSpecialization(@RequestParam("specialization") String specialization, ModelAndView modelAndView) {
        log.info("Adding specialization: " + specialization);

        if (specialization == null || specialization.trim().isEmpty()) {
            modelAndView.addObject("error", "Specialization cannot be empty");
            modelAndView.setViewName("Specialization");
            return modelAndView;
        }

        boolean isAdded = adminService.addSpecialization(specialization);

        if (isAdded) {
            modelAndView.addObject("success", "Specialization added successfully");
        } else {
            modelAndView.addObject("error", "Failed to add specialization");
        }

        modelAndView.setViewName("Specialization");
        return modelAndView;
    }

    @RequestMapping("/openSetSlotForm")
    public ModelAndView openSetSlotPage(ModelAndView modelAndView) {
        List<String> specializations = adminService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("SetSlot");
        return modelAndView;
    }

    @RequestMapping("/redirectToSlot")
    public ModelAndView redirectToSlot(ModelAndView modelAndView) {
        List<String> specializations = adminService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("Slots");
        return modelAndView;
    }

    @PostMapping("/saveDoctorSlots")
    public ModelAndView saveDoctorSlots(@RequestParam String email, String slotTimings, ModelAndView modelAndView) {

        if (email == null || email.trim().isEmpty() || slotTimings == null || slotTimings.trim().isEmpty()) {
            modelAndView.addObject("error", "Email and Slot Timings cannot be empty");
            modelAndView.setViewName("Slots");
            return modelAndView;
        }

        log.info("Email: " + email);
        log.info("Slot Timings: " + slotTimings);

        boolean result = adminService.saveDoctorSlots(email, slotTimings);
        if (!result) {
            modelAndView.addObject("error", "Failed to allocate slots to doctor");
            List<String> specializations = adminService.getAllSpecializations();
            modelAndView.addObject("specializations", specializations);
            modelAndView.setViewName("Slots");
        } else {
            List<String> specializations = adminService.getAllSpecializations();
            modelAndView.addObject("specializations", specializations);
            modelAndView.setViewName("Slots");
            modelAndView.addObject("success", "Slots allocated to doctor successfully");
        }
        return modelAndView;
    }

    @RequestMapping("/logOut")
    public ModelAndView logOut(ModelAndView modelAndView, HttpSession session) {
        session.invalidate();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
