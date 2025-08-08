package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.OnionDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class OnionComponent {

    public OnionComponent(){
        System.out.println("no arg cont of OnionComponent");
    }

    @RequestMapping("/onion")
    public String addOnion(OnionDTO onionDTO){
        System.out.println("Onion size is :"+onionDTO.getSize());
        System.out.println("Onion price is :"+onionDTO.getPrice());
        System.out.println("Onion added to the cart");
        return "onion.jsp";
    }
}
