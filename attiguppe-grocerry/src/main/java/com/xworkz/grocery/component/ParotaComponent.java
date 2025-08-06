package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ParotaComponent {

    public ParotaComponent(){
        System.out.println("no arg const of ParotaComponent");
    }

    @RequestMapping("/parota")
    public String adaParota(@RequestParam ("type") String type,@RequestParam("price") int price){
        System.out.println("Parota type is : "+type);
        System.out.println("Parota price is : "+price);
        System.out.println("Parota added to the cart");
        return "parota.jsp";
    }

}
