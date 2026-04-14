package com.xworkz.hospital.controller;

import com.xworkz.hospital.service.AdminService;
import com.xworkz.hospital.service.SpecializationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/")
@Slf4j
public class AdminController {

    public AdminController() {
        log.info("No arg const of AdminController");
    }

    @Autowired
    AdminService adminService;

    @Autowired
    SpecializationService specializationService;

    @RequestMapping("/AdminLogin")
    public String openAdminLoginForm(){
        log.info("Running openAdminLoginForm in HospitalController");
        return "AdminLogin";
    }

    @RequestMapping("/admin")
    public String redirectToAdminPage(){
        log.info("Running redirectToAdminPage in HospitalController");
        return "Admin";
    }

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

    @RequestMapping("/logOut")
    public ModelAndView logOut(ModelAndView modelAndView, HttpSession session) {
        session.invalidate();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
