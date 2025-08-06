package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class BiryaniComponent {

    public BiryaniComponent(){
        System.out.println("No arg const of BiryaniComponent");
    }

    @RequestMapping("/biryani")
    public String addBiryani(@RequestParam ("biryaniType") String type , @RequestParam ("price") int price){
        System.out.println("Type is : "+type);
        System.out.println("Price is : "+price);
        System.out.println("Biryani added to the cart");
        return "biryani.jsp";
    }

}
