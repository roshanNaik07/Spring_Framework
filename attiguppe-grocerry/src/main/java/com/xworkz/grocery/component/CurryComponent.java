package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class CurryComponent {

    public CurryComponent(){
        System.out.println("No arg const of CurryComponent");
    }

    @RequestMapping("/curry")
    public String addCurry(@RequestParam("type") String type , @RequestParam("price") int price){

        System.out.println("Curry type is : "+type);
        System.out.println("Curry price is :"+price);
        System.out.println("Curry added to the cart");
        return "curry.jsp";
    }
}
