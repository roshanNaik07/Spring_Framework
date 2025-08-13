package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ShoeDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ShoeController {

    public ShoeController(){
        System.out.println("no arg const of ShoeComponent");
    }

    @RequestMapping("/shoe")
    public String addShoe(ShoeDTO shoeDTO, Model model){
        System.out.println("Shoe brand is : "+shoeDTO.getBrand());
        System.out.println("Shoe price is : "+shoeDTO.getPrice());
        System.out.println("Shoe added to the cart");
        model.addAttribute("brand",shoeDTO.getBrand());
        model.addAttribute("price",shoeDTO.getPrice());
        return "shoe.jsp";
    }

}
