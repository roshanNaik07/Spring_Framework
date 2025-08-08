package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.BottleDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class BottleComponent {

    public BottleComponent(){
        System.out.println("no arg const of BottleComponent");
    }

    @RequestMapping("/bottle")
    public String addBottle(BottleDTO bottleDTO){
        System.out.println("Bottle color : "+bottleDTO.getColor());
        System.out.println("Bottle price : "+bottleDTO.getPrice());
        System.out.println("Added bottle to the cart");
        return "bottle.jsp";
    }

}
