package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class MashroomComponent {

    public MashroomComponent(){
        System.out.println("no arg const of mashroom component");
    }

    @RequestMapping("/mashroom")
    public String addMashroom(){
        System.out.println("Added mashroom to the cart");
        return "mashroom.jsp";
    }


}
