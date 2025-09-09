package com.xworkz.hospital.restController;

import com.xworkz.hospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AdminRestController {

    @Autowired
    AdminService adminService;

    @GetMapping("checkEmail/{email}")
    public String checkEmail(@PathVariable String email){
        boolean result = adminService.checkEmail(email);
        if (result){
            return "";
        }
        return "Admin email doesn't exists";
    }

}
