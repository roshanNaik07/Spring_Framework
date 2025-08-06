package com.xworkz.grocery.component;

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
    public String addOnion(@RequestParam("size") String size,@RequestParam("price") int price){
        System.out.println("Onion size is :"+size);
        System.out.println("Onion price is :"+price);
        System.out.println("Onion added to the cart");
        return "onion.jsp";
    }
}
