package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class MilkComponent {

    public MilkComponent(){
        System.out.println("No arg const of MilkComponent");
    }

    @RequestMapping("/milk")
    public String addMilk(@RequestParam("brand") String brand ,@RequestParam("price") int price){
        System.out.println("Milk brand is :"+brand);
        System.out.println("Milk price is :"+price);
        System.out.println("Added milk to the cart");
        return "milk.jsp";
    }
}
