package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ShoeComponent {

    public ShoeComponent(){
        System.out.println("no arg const of ShoeComponent");
    }

    @RequestMapping("/shoe")
    public String addShoe(@RequestParam ("brand") String brand ,@RequestParam ("price") int price){
        System.out.println("Shoe brand is : "+brand);
        System.out.println("Shoe price is : "+price);
        System.out.println("Shoe added to the cart");
        return "shoe.jsp";
    }

}
