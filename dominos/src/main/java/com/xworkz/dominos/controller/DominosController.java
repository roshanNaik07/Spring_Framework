package com.xworkz.dominos.controller;

import com.xworkz.dominos.dto.DominosDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@EnableWebMvc
public class DominosController implements WebMvcConfigurer {

    public DominosController(){
        System.out.println("DominosController created by spring");
    }

    @RequestMapping("/order")
    public String getFormDetails(@Valid DominosDto dto, BindingResult bindingResult, Model model){
        System.out.println("Running getFormDetails method");

        if (bindingResult.hasErrors()){
            System.out.println("Invalid data");
            List<ObjectError> objectErrors =  bindingResult.getAllErrors();

            for (ObjectError objectError : objectErrors){
                System.out.println(objectError.getDefaultMessage());
                model.addAttribute("error",objectError.getDefaultMessage());
                model.addAttribute("value",dto);
                return "Dominos.jsp";
            }
        }
        model.addAttribute("name",dto.getName());
        model.addAttribute("email",dto.getEmail());
        model.addAttribute("phoneNo",dto.getPhoneNo());
        model.addAttribute("price",dto.getPrice());
        return "DominosResult.jsp";
    }

}
