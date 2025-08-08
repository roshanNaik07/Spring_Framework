package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ShoeDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ShoeComponent {

    public ShoeComponent(){
        System.out.println("no arg const of ShoeComponent");
    }

    @RequestMapping("/shoe")
    public String addShoe(ShoeDTO shoeDTO){
        System.out.println("Shoe brand is : "+shoeDTO.getBrand());
        System.out.println("Shoe price is : "+shoeDTO.getPrice());
        System.out.println("Shoe added to the cart");
        return "shoe.jsp";
    }

}
