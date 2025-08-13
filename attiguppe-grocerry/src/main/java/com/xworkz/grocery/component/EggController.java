package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.EggDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class EggController {

    public EggController(){
        System.out.println("No arg const of EggComponent");
    }

    @RequestMapping("/egg")
    public String addEgg(EggDTO eggDTO, Model model){
        System.out.println("egg size is :"+eggDTO.getSize());
        System.out.println("egg price is :"+eggDTO.getPrice());
        System.out.println("Egg added to the cart");
        model.addAttribute("size",eggDTO.getSize());
        model.addAttribute("price",eggDTO.getPrice());
        return "egg.jsp";
    }
}
