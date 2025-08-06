package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class EggComponent {

    public EggComponent(){
        System.out.println("No arg const of EggComponent");
    }

    @RequestMapping("/egg")
    public String addEgg(@RequestParam ("size") String size,@RequestParam("price") int price){
        System.out.println("egg size is :"+size);
        System.out.println("egg price is :"+price);
        System.out.println("Egg added to the cart");
        return "egg.jsp";
    }
}
