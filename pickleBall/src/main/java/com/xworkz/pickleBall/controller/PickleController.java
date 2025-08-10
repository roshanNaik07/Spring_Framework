package com.xworkz.pickleBall.controller;

import com.xworkz.pickleBall.dto.PickleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class PickleController {

    public PickleController(){
        System.out.println("PickleController created by spring");
    }

    @RequestMapping("/pickle")
    public String getDetails(PickleDto pickleDto){
        System.out.println("Name is :"+pickleDto.getName());
        System.out.println("Player count is :"+pickleDto.getCount());
        System.out.println("Timing :"+pickleDto.getTime());
        return "Pickle.jsp";
    }

}
