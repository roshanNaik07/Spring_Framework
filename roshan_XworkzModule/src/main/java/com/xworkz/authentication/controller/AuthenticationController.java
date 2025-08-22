package com.xworkz.authentication.controller;

import com.xworkz.authentication.dto.AuthenticationDto;
import com.xworkz.authentication.dto.UpdateDto;
import com.xworkz.authentication.service.AuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
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
    public ModelAndView signIn(@RequestParam String userName, @RequestParam String password, ModelAndView modelAndView , HttpSession session) {

        if (userName.isEmpty() || password.isEmpty()) {
            modelAndView.addObject("error", "username and password cannot be empty");
            modelAndView.setViewName("SignIn");
            return modelAndView;
        }

        AuthenticationDto authenticationDto = authenticationService.signIn(userName, password);
        if (authenticationDto == null) {
            System.out.println("Not matched");
            modelAndView.addObject("error", "Cannot find user");
            modelAndView.setViewName("SignIn");
            return modelAndView;
        }
        UpdateDto updateDto = new UpdateDto();
        BeanUtils.copyProperties(authenticationDto,updateDto);
        session.setAttribute("userSignData",updateDto);
        modelAndView.addObject("logInSuccess", "Hi " + userName + ",Successfully Logged In... Welcome to xworkz");
        modelAndView.setViewName("Profile");
        return modelAndView;
    }

    @RequestMapping("/forgotPassword")
    public ModelAndView forgetPassword(@Valid AuthenticationDto authenticationDto, BindingResult bindingResult, ModelAndView modelAndView) {

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
        if (!result) {
            modelAndView.addObject("error", "No such email registered");
            modelAndView.setViewName("ForgotPassword");
            return modelAndView;
        }

        modelAndView.addObject("updatedPassword", "Password updated successfully");
        modelAndView.setViewName("SignIn");
        return modelAndView;
    }

    @RequestMapping("/openUpdatePage")
    public ModelAndView openUpdateProfile(ModelAndView modelAndView , HttpSession session) {

        System.out.println("Running openUpdateProfile in AuthenticationController");

        UpdateDto updateDto = (UpdateDto) session.getAttribute("userSignData");

        modelAndView.addObject("userData",updateDto);
        modelAndView.setViewName("UpdateProfile");
        return modelAndView;
    }

    @RequestMapping("/updateUserData")
    public ModelAndView updateSignInDetails(@Valid  UpdateDto updateDto ,BindingResult bindingResult , ModelAndView modelAndView){
        System.out.println("Running updateSignInDetails"+updateDto);

        if (bindingResult.hasErrors()){
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            for (ObjectError error : objectErrors){
                modelAndView.addObject("error",error.getDefaultMessage());
                modelAndView.addObject("userData",updateDto);
                modelAndView.setViewName("UpdateProfile");
                return modelAndView;
            }
        }

        UpdateDto updateDto1 = authenticationService.updateUserData(updateDto);
        System.out.println(updateDto1);
        modelAndView.addObject("userData",updateDto1);
        modelAndView.setViewName("UpdateProfile");
        return modelAndView;
    }
}
