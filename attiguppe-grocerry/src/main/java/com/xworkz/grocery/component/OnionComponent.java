package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class OnionComponent {

    public OnionComponent(){
        System.out.println("no arg cont of OnionComponent");
    }

    @RequestMapping("/onion")
    public String addOnion(){
        System.out.println("Onion added to the cart");
        return "onion.jsp";
    }
}
