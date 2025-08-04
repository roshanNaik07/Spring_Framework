package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class BottleComponent {

    public BottleComponent(){
        System.out.println("no arg const of BottleComponent");
    }

    @RequestMapping("/bottle")
    public String addBottle(){
        System.out.println("Added bottle to the cart");
        return "bottle.jsp";
    }

}
