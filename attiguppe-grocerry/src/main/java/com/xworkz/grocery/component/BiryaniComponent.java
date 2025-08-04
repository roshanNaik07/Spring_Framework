package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class BiryaniComponent {

    public BiryaniComponent(){
        System.out.println("No arg const of BiryaniComponent");
    }

    @RequestMapping("/biryani")
    public String addBiryani(){
        System.out.println("Biryani added to the cart");
        return "biryani.jsp";
    }

}
