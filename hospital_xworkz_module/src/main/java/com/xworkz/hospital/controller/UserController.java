package com.xworkz.hospital.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class UserController {

    public UserController(){
        log.info("Running no argument constructor of UserController");
    }

    @RequestMapping("/UserLogin")
    public String userLogin(){
        return "UserLogin";
    }

    @RequestMapping("/userRegister")
    public String UserRegister(){
        return "UserRegister";
    }

}
