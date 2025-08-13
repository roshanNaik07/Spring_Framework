package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.MilkDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class MilkController {

    public MilkController(){
        System.out.println("No arg const of MilkComponent");
    }

    @RequestMapping("/milk")
    public String addMilk(MilkDTO milkDTO, Model model){
        System.out.println("Milk brand is :"+milkDTO.getBrand());
        System.out.println("Milk price is :"+milkDTO.getPrice());
        System.out.println("Added milk to the cart");
        model.addAttribute("brand",milkDTO.getBrand());
        model.addAttribute("price",milkDTO.getPrice());
        return "milk.jsp";
    }
}
