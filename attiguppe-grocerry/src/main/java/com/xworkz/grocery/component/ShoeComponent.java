package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ShoeComponent {

    public ShoeComponent(){
        System.out.println("no arg const of ShoeComponent");
    }

    @RequestMapping("/shoe")
    public String addShoe(){
        System.out.println("Shoe added to the cart");
        return "shoe.jsp";
    }

}
