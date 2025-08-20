package com.xworkz.authentication.controller;

import com.xworkz.authentication.dto.AuthenticationDto;
import com.xworkz.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    public AuthenticationController() {
        System.out.println("AuthenticationController created by spring");
    }

    @RequestMapping("/signUp")
    public ModelAndView saveSignUpDetails(@Valid AuthenticationDto authenticationDto, BindingResult bindingResult, ModelAndView modelAndView) {

        if (!authenticationDto.getPassword().equals(authenticationDto.getConfirmPassword())) {
            modelAndView.addObject("error", "password and confirm password doesn't match");
            modelAndView.addObject("value", authenticationDto);
            modelAndView.setViewName("SignUp");
            return modelAndView;
        }

        if (bindingResult.hasErrors()) {
            System.out.println("Invalid Data");
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError objectError : errors) {
                System.out.println(objectError.getDefaultMessage());
                modelAndView.addObject("error", objectError.getDefaultMessage());
                modelAndView.addObject("value", authenticationDto);
                modelAndView.setViewName("SignUp");
                return modelAndView;
            }
        }

        Boolean result = authenticationService.saveSignUpDetails(authenticationDto);
        System.out.println(result);
        modelAndView.addObject("success", "Registered Successfully");
        modelAndView.setViewName("SignIn");
        return modelAndView;
    }

    @RequestMapping("/signIn")
    public ModelAndView signIn(@RequestParam String userName, @RequestParam String password, ModelAndView modelAndView) {

        if (userName.isEmpty() || password.isEmpty()) {
            modelAndView.addObject("error", "username and password cannot be empty");
            modelAndView.setViewName("SignIn");
            return modelAndView;
        }

        boolean result = authenticationService.signIn(userName, password);
        if (!result) {
            System.out.println("Not matched");
            modelAndView.addObject("error", "Cannot find user");
            modelAndView.setViewName("SignIn");
            return modelAndView;
        }
        System.out.println("matched");
        modelAndView.addObject("logInSuccess", "Successfully Logged In");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/forgotPassword")
    private ModelAndView forgetPassword(@Valid AuthenticationDto authenticationDto, BindingResult bindingResult, ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            for (ObjectError error : objectErrors) {
                if (error.getDefaultMessage().equals("Password must be at least 5 characters and contain both letters and numbers") || error.getDefaultMessage().equals("Confirm Password cannot be empty")) {
                    modelAndView.addObject("error", "Enter Strong Password");
                    modelAndView.setViewName("ForgotPassword");
                    return modelAndView;
                }
            }
        }

        boolean result = authenticationService.forgotPassword(authenticationDto.getEmail(), authenticationDto.getPassword(), authenticationDto.getConfirmPassword());
        if (!result){
            modelAndView.addObject("error", "No such email registered");
            modelAndView.setViewName("ForgotPassword");
            return modelAndView;
        }

        modelAndView.addObject("updatedPassword", "Password updated successfully");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
