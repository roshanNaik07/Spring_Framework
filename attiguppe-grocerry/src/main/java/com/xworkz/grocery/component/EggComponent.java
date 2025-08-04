package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class EggComponent {

    public EggComponent(){
        System.out.println("No arg const of EggComponent");
    }

    @RequestMapping("/egg")
    public String addEgg(){
        System.out.println("Egg added to the cart");
        return "egg.jsp";
    }
}
