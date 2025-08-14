package com.xworkz.dominos.controller;

import com.xworkz.dominos.dto.DominosDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DominosController {

    public DominosController(){
        System.out.println("DominosController created by spring");
    }

    @RequestMapping("/order")
    public String getFormDetails(DominosDto dto){
        System.out.println("Name : " +dto.getName());
        System.out.println("Email : " +dto.getEmail());
        System.out.println("PhoneNo : " +dto.getPhoneNo());
        System.out.println("Price : " +dto.getPrice());
        return "Dominos.jsp";
    }

}
