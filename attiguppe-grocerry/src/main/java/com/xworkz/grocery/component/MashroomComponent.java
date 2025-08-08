package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.MashroomDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class MashroomComponent {

    public MashroomComponent(){
        System.out.println("no arg const of mashroom component");
    }

    @RequestMapping("/mashroom")
    public String addMashroom(MashroomDTO mashroomDTO){
        System.out.println("Mashroom type is :"+mashroomDTO.getType());
        System.out.println("Mashroom price is : "+mashroomDTO.getPrice());
        System.out.println("Added mashroom to the cart");
        return "mashroom.jsp";
    }


}
