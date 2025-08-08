package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.MilkDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class MilkComponent {

    public MilkComponent(){
        System.out.println("No arg const of MilkComponent");
    }

    @RequestMapping("/milk")
    public String addMilk(MilkDTO milkDTO){
        System.out.println("Milk brand is :"+milkDTO.getBrand());
        System.out.println("Milk price is :"+milkDTO.getPrice());
        System.out.println("Added milk to the cart");
        return "milk.jsp";
    }
}
