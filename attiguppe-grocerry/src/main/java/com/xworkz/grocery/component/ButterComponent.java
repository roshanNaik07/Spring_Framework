package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ButterComponent {

    public ButterComponent(){
        System.out.println("no arg const of ButterComponent");
    }

    @RequestMapping("/butter")
    public String addButter(@RequestParam("brand") String brand ,@RequestParam("price") int price){
        System.out.println("brand is : "+brand);
        System.out.println("price is : "+price);
        System.out.println("Butter added to the cart");
        return "butter.jsp";
    }

}
