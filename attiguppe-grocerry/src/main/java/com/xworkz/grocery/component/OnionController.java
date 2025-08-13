package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.OnionDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class OnionController {

    public OnionController(){
        System.out.println("no arg cont of OnionComponent");
    }

    @RequestMapping("/onion")
    public String addOnion(OnionDTO onionDTO, Model model){
        System.out.println("Onion size is :"+onionDTO.getSize());
        System.out.println("Onion price is :"+onionDTO.getPrice());
        System.out.println("Onion added to the cart");
        model.addAttribute("size",onionDTO.getSize());
        model.addAttribute("price",onionDTO.getPrice());
        return "onion.jsp";
    }
}
