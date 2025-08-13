package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.MashroomDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class MashroomController {

    public MashroomController(){
        System.out.println("no arg const of mashroom component");
    }

    @RequestMapping("/mashroom")
    public String addMashroom(MashroomDTO mashroomDTO , Model model){
        System.out.println("Mashroom type is :"+mashroomDTO.getType());
        System.out.println("Mashroom price is : "+mashroomDTO.getPrice());
        System.out.println("Added mashroom to the cart");
        model.addAttribute("type",mashroomDTO.getType());
        model.addAttribute("price",mashroomDTO.getPrice());
        return "mashroom.jsp";
    }


}
