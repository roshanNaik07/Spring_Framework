package com.xworkz.hospital.controller;

import com.xworkz.hospital.constant.Specialization;
import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class AdminController {

    public AdminController() {
        System.out.println("No arg const of AdminController");
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
    public ModelAndView verifyOTP(ModelAndView modelAndView, String otp, String email) {
        System.out.println("Running verifyOTP in adminController");
        boolean result = adminService.verifyOTP(otp);
        if (result) {
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
    public ModelAndView openDoctorRegistrationPage(ModelAndView modelAndView){

        modelAndView.setViewName("RegisterDoctor");
        return modelAndView;
    }

    @RequestMapping("/openSlot")
    public ModelAndView openSlots(ModelAndView modelAndView){
        modelAndView.setViewName("Slots");
        return modelAndView;
    }

    @PostMapping("/registerDoctor")
    public ModelAndView saveDoctorsData(@RequestParam("image") MultipartFile multipartFile, @Valid DoctorRegistrationDTO doctorRegistrationDTO, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {
        System.out.println("Entered saveDoctorsData");

        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get("D:\\Hospital\\" + doctorRegistrationDTO.getName() + System.currentTimeMillis() + ".jpg");
        Files.write(path, bytes);
        String imageName = path.getFileName().toString();
        doctorRegistrationDTO.setImageName(imageName);

        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
                modelAndView.addObject("error", error.getDefaultMessage());
                modelAndView.addObject("values", doctorRegistrationDTO);
                modelAndView.setViewName("RegisterDoctor");
            }
        } else {
            System.out.println(doctorRegistrationDTO.toString());
            adminService.registerDoctor(doctorRegistrationDTO);
            modelAndView.setViewName("Admin");
        }
        return modelAndView;
    }

    @PostMapping("/saveSlot")
    public ModelAndView saveSlotTimings(@Valid SlotTimeDTO slotTimeDTO,BindingResult bindingResult, ModelAndView modelAndView){

        if (bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors){
                System.out.println(error.getDefaultMessage());
                modelAndView.addObject("error",error.getDefaultMessage());
                modelAndView.setViewName("SetSlot");
            }
        }
        LocalTime startTime=LocalTime.parse(slotTimeDTO.getSlotStartTime());
        LocalTime endTime=LocalTime.parse(slotTimeDTO.getSlotEndTime());

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm a");
        slotTimeDTO.setSlotStartTime(startTime.format(formatter));
        slotTimeDTO.setSlotEndTime(endTime.format(formatter));

        adminService.saveSlotTime(slotTimeDTO);
        modelAndView.setViewName("Slots");
        return modelAndView;
    }

    @GetMapping("/getBySpecialization")
    public ModelAndView showDoctorSlotForm(@RequestParam String specialization ,ModelAndView modelAndView){
        System.out.println("Entered showDoctorSlotForm method "+specialization);

        Map<String, String> values = new HashMap<>();
        values.put("specialization", specialization);

        modelAndView.addObject("values", specialization);
        modelAndView.setViewName("Slots");
        return modelAndView;
    }

}
