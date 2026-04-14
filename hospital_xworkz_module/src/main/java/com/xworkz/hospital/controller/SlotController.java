package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.service.SlotService;
import com.xworkz.hospital.service.SpecializationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class SlotController {

    @Autowired
    SlotService slotService;

    @Autowired
    SpecializationService specializationService;

    public SlotController() {
        log.info("Running SlotController");
    }

    @RequestMapping("/slots")
    public ModelAndView openSlotsPage(ModelAndView modelAndView) {
        List<String> specializations = specializationService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("Slots");
        return modelAndView;
    }

    @RequestMapping("/setSlot")
    public ModelAndView openSetSlotPage(ModelAndView modelAndView) {
        List<String> specializations = specializationService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("SetSlot");
        return modelAndView;
    }

    @PostMapping("/saveSlot")
    public ModelAndView saveSlotTimings(@Valid SlotTimeDTO slotTimeDTO, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            List<String> specializations = specializationService.getAllSpecializations();
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
        slotService.saveSlotTime(slotTimeDTO);
        List<String> specializations = specializationService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.addObject("success", "Slot timings saved successfully");
        modelAndView.setViewName("Slots");
        return modelAndView;
    }

    @GetMapping("/getBySpecialization")
    public ModelAndView showDoctorSlotForm(@RequestParam String specialization, ModelAndView modelAndView) {
        List<String> specializations = specializationService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        List<DoctorRegistrationDTO> doctorRegistrationDTOList = slotService.getDoctorDtoBySpecialization(specialization);
        List<String> slotTimings = slotService.getAllSlotsBySpecialization(specialization);
        if (doctorRegistrationDTOList.isEmpty()) {
            modelAndView.addObject("openDoctorSlotForm", "");
            modelAndView.addObject("error", "No Doctor's available for " + specialization);
        } else {
            modelAndView.addObject("specialization", specialization);
            modelAndView.addObject("slotTimings", slotTimings);
            modelAndView.addObject("openDoctorSlotForm", "found Doctor's");
            modelAndView.addObject("doctorRegistrationDTOList", doctorRegistrationDTOList);
        }

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
        boolean result = slotService.saveDoctorSlots(email, slotTimings);
        if (!result) {
            modelAndView.addObject("error", "Failed to allocate slots to doctor");
            List<String> specializations = specializationService.getAllSpecializations();
            modelAndView.addObject("specializations", specializations);
            modelAndView.setViewName("Slots");
        } else {
            List<String> specializations = specializationService.getAllSpecializations();
            modelAndView.addObject("specializations", specializations);
            modelAndView.setViewName("Slots");
            modelAndView.addObject("success", "Slots allocated to doctor successfully");
        }
        return modelAndView;
    }

    @RequestMapping("/redirectToSlot")
    public ModelAndView redirectToSlot(ModelAndView modelAndView) {
        List<String> specializations = specializationService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("Slots");
        return modelAndView;
    }

}
