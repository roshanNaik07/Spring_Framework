package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class BottleComponent {

    public BottleComponent(){
        System.out.println("no arg const of BottleComponent");
    }

    @RequestMapping("/bottle")
    public String addBottle(@RequestParam ("color") String color, @RequestParam("price") int price){
        System.out.println("Bottle color : "+color);
        System.out.println("Bottle price : "+price);
        System.out.println("Added bottle to the cart");
        return "bottle.jsp";
    }

}
