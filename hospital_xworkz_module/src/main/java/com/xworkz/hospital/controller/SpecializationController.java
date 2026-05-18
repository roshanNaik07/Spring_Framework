package com.xworkz.hospital.controller;

import com.xworkz.hospital.service.SpecializationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("/")
public class SpecializationController {

    @Autowired
    SpecializationService specializationService;

    public SpecializationController(){
        log.info("Running SpecializationController");
    }

    @RequestMapping("/specialization")
    public String openSetSpecialization(){
        log.info("Running openSetSpecialization");
        return "Specialization";
    }

    @PostMapping("/specializationUpdate")
    public ModelAndView addSpecialization(@RequestParam("specialization") String specialization, ModelAndView modelAndView) {
        log.info("Adding specialization: " + specialization);

        if (specialization == null || specialization.trim().isEmpty()) {
            modelAndView.addObject("error", "Specialization cannot be empty");
            modelAndView.setViewName("Specialization");
            return modelAndView;
        }

        boolean isAdded = specializationService.addSpecialization(specialization);

        if (isAdded) {
            modelAndView.addObject("success", "Specialization added successfully");
        } else {
            modelAndView.addObject("error", "Failed to add specialization");
        }

        modelAndView.setViewName("Specialization");
        return modelAndView;
    }

}
