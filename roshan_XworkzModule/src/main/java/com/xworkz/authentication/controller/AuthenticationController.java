package com.xworkz.authentication.controller;

import com.xworkz.authentication.dto.AuthenticationDto;
import com.xworkz.authentication.dto.UpdateDto;
import com.xworkz.authentication.service.AuthenticationService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Session;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    public AuthenticationController() {
        System.out.println("AuthenticationController created by spring");
    }

    @PostMapping("/signUp")
    public ModelAndView saveSignUpDetails(@RequestParam("image") MultipartFile multipartFile, @Valid AuthenticationDto authenticationDto, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {

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

        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get("D:\\roshanimage\\" + authenticationDto.getName() + System.currentTimeMillis() + ".jpg");

        Files.write(path, bytes);
        String imageName = path.getFileName().toString();
        System.out.println("image name " + imageName);
        authenticationDto.setImageName(imageName);

        Boolean result = authenticationService.saveSignUpDetails(authenticationDto);
        System.out.println(result);
        modelAndView.addObject("success", "Registered Successfully");
        modelAndView.setViewName("SignIn");
        return modelAndView;
    }

    @RequestMapping("/signIn")
    public ModelAndView signIn(@RequestParam String userName, @RequestParam String password, ModelAndView modelAndView, HttpSession session) {

        AuthenticationDto authenticationDto = authenticationService.signIn(userName, password);

        if (userName.isEmpty() || password.isEmpty()) {
            modelAndView.addObject("error", "username and password cannot be empty");
            modelAndView.setViewName("SignIn");
        } else if (authenticationDto == null) {
            System.out.println("Not matched");
            modelAndView.addObject("error", "Invalid Credentials");
            modelAndView.setViewName("SignIn");
        } else if (authenticationDto.getName().equals("Locked")) {
            modelAndView.addObject("error", "Ur account is locked");
            modelAndView.setViewName("SignIn");
        } else {
            session.removeAttribute("userSignData");
            UpdateDto updateDto = new UpdateDto();
            BeanUtils.copyProperties(authenticationDto, updateDto);
            System.out.println("Image name is : "+updateDto.getImageName());
            session.setAttribute("userSignData", updateDto);
            modelAndView.addObject("logInSuccess", "Hi " + userName);
            modelAndView.setViewName("Profile");
        }
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
    public ModelAndView openUpdateProfile(ModelAndView modelAndView, HttpSession session) {

        System.out.println("Running openUpdateProfile in AuthenticationController");

        UpdateDto updateDto = (UpdateDto) session.getAttribute("userSignData");
        System.out.println(" showing image name is : "+updateDto.getImageName());

        modelAndView.addObject("userData", updateDto);
        modelAndView.setViewName("UpdateProfile");
        return modelAndView;
    }

    @PostMapping("/updateUserData")
    public ModelAndView updateUserDetails(@RequestParam("image") MultipartFile multipartFile ,@Valid UpdateDto updateDto, BindingResult bindingResult, ModelAndView modelAndView,HttpSession session) throws IOException {
        System.out.println("Running updateUserDetails" + updateDto);
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            for (ObjectError error : objectErrors) {
                modelAndView.addObject("error", error.getDefaultMessage());
                modelAndView.addObject("userData", updateDto);
                modelAndView.setViewName("UpdateProfile");
                return modelAndView;
            }
        }

        UpdateDto updateDto1 = authenticationService.updateUserData(updateDto);
        System.out.println(updateDto1.getImageName());

        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get("D:\\roshanimage\\"  + updateDto1.getName() + System.currentTimeMillis() + ".jpg");
        Files.write(path,bytes);
        String updatedImageName = path.getFileName().toString();
        System.out.println(updatedImageName);
        updateDto.setImageName(updatedImageName);

        session.setAttribute("userSignData",updateDto1);
        modelAndView.addObject("logInSuccess", "hi "+updateDto1.getName()+" ,Profile Updated");
        modelAndView.setViewName("Profile");
        return modelAndView;
    }

    @GetMapping("/download")
    public void getImage(HttpServletResponse response , @RequestParam String fileName) throws IOException {
        response.setContentType("image/jpg");
        File file = new File("D:\\roshanimage\\"+fileName);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream servletOutputStream = response.getOutputStream();
        IOUtils.copy(inputStream,servletOutputStream);

        response.flushBuffer();
    }

}
