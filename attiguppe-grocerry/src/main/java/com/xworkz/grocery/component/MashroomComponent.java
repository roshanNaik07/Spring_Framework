package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class MashroomComponent {

    public MashroomComponent(){
        System.out.println("no arg const of mashroom component");
    }

    @RequestMapping("/mashroom")
    public String addMashroom(@RequestParam("type") String type , @RequestParam("price") int price){
        System.out.println("Mashroom type is :"+type);
        System.out.println("Mashroom price is : "+price);
        System.out.println("Added mashroom to the cart");
        return "mashroom.jsp";
    }


}
