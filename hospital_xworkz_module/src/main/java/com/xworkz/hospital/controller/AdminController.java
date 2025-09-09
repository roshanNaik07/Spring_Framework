package com.xworkz.hospital.controller;

import com.xworkz.hospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AdminController {

    public AdminController(){
        System.out.println("No arg const of AdminController");
    }

    @Autowired
    AdminService adminService;

    @RequestMapping("/send-otp")
    public ModelAndView sendOTP(ModelAndView modelAndView,String email){

        System.out.println("Running sendOTP");
        boolean result = adminService.sendOTP(email);
        if (result){
            modelAndView.addObject("email",email);
            modelAndView.addObject("showotpField",result);
            modelAndView.setViewName("AdminLogin");
        }else {
            modelAndView.addObject("error","Email not found");
            modelAndView.addObject("showotpField","");
            modelAndView.setViewName("AdminLogin");
        }
        return modelAndView;
    }

    @RequestMapping("/verify-otp")
    public ModelAndView verifyOTP(ModelAndView modelAndView,String otp,String email){
        System.out.println("Running verifyOTP in adminController");
        boolean result = adminService.verifyOTP(otp);
        if (result){
            modelAndView.setViewName("index");
        }else {
            modelAndView.addObject("email",email);
            modelAndView.addObject("showotpField",result);
            modelAndView.addObject("error","OTP is wrong");
            modelAndView.setViewName("AdminLogin");
        }
        return modelAndView;
    }

}
