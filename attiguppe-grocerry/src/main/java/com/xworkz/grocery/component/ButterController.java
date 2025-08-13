package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ButterDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ButterController {

    public ButterController(){
        System.out.println("no arg const of ButterComponent");
    }

    @RequestMapping("/butter")
    public String addButter(ButterDTO butterDTO, Model model){
        System.out.println("brand is : "+butterDTO.getBrand());
        System.out.println("price is : "+butterDTO.getPrice());
        System.out.println("Butter added to the cart");

        model.addAttribute("brand",butterDTO.getBrand());
        model.addAttribute("price",butterDTO.getPrice());
        return "butter.jsp";
    }

}
