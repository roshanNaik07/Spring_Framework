package com.xworkz.hospital.controller;

import com.xworkz.hospital.service.AdminService;
import com.xworkz.hospital.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Repository("/")
@Slf4j
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AdminService adminService;

    @RequestMapping("/openPatientRegisterPage")
    public ModelAndView openPatientRegisterForm(ModelAndView modelAndView) {
        log.info("Running openPatientRegisterForm in PatientController");
        List<String> bloodGroups = patientService.getAllBloodGroups();
        List<String> specializations = adminService.getAllSpecializations();
        if (bloodGroups != null && !bloodGroups.isEmpty() && specializations != null && !specializations.isEmpty()) {
            modelAndView.addObject("bloodGroups", bloodGroups);
            modelAndView.addObject("specializations", specializations);
        } else {
            log.info("No blood groups found");
            modelAndView.addObject("bloodGroups", bloodGroups);
        }
        modelAndView.setViewName("PatientRegistration");
        return modelAndView;
    }

}
