package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ParotaComponent {

    public ParotaComponent(){
        System.out.println("no arg const of ParotaComponent");
    }

    @RequestMapping("/parota")
    public String adaParota(){
        System.out.println("Parota added to the cart");
        return "parota.jsp";
    }

}
