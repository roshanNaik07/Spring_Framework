package com.xworkz.authentication.controller;

import com.xworkz.authentication.dto.AuthenticationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    public AuthenticationController(){
        System.out.println("AuthenticationController created by spring");
    }

    @RequestMapping("/signUp")
    public ModelAndView saveSignUpDetails(AuthenticationDto authenticationDto,ModelAndView modelAndView){

        System.out.println(authenticationDto);

        modelAndView.setViewName("SignUp");
        return modelAndView;
    }
}
