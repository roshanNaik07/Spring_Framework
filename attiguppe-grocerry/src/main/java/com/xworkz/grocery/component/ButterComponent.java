package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ButterDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ButterComponent {

    public ButterComponent(){
        System.out.println("no arg const of ButterComponent");
    }

    @RequestMapping("/butter")
    public String addButter(ButterDTO butterDTO){
        System.out.println("brand is : "+butterDTO.getBrand());
        System.out.println("price is : "+butterDTO.getPrice());
        System.out.println("Butter added to the cart");
        return "butter.jsp";
    }

}
