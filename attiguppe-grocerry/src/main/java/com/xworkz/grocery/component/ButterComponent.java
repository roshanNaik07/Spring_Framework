package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ButterComponent {

    public ButterComponent(){
        System.out.println("no arg const of ButterComponent");
    }

    @RequestMapping("/butter")
    public String addButter(){
        System.out.println("Butter added to the cart");
        return "butter.jsp";
    }

}
