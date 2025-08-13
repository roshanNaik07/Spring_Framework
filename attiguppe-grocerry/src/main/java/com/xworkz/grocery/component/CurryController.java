package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.CurryDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class CurryController {

    public CurryController(){
        System.out.println("No arg const of CurryComponent");
    }

    @RequestMapping("/curry")
    public String addCurry(CurryDTO curryDTO, Model model){

        System.out.println("Curry type is : "+curryDTO.getType());
        System.out.println("Curry price is :"+curryDTO.getPrice());
        System.out.println("Curry added to the cart");
        model.addAttribute("type",curryDTO.getType());
        model.addAttribute("price",curryDTO.getPrice());
        return "curry.jsp";
    }
}
