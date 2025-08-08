package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.EggDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class EggComponent {

    public EggComponent(){
        System.out.println("No arg const of EggComponent");
    }

    @RequestMapping("/egg")
    public String addEgg(EggDTO eggDTO){
        System.out.println("egg size is :"+eggDTO.getSize());
        System.out.println("egg price is :"+eggDTO.getPrice());
        System.out.println("Egg added to the cart");
        return "egg.jsp";
    }
}
