package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class MilkComponent {

    public MilkComponent(){
        System.out.println("No arg const of MilkComponent");
    }

    @RequestMapping("/milk")
    public String addMilk(){
        System.out.println("Added milk to the cart");
        return "milk.jsp";
    }
}
