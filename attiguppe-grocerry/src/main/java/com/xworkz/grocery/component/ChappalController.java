package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ChappalDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ChappalController {

    public ChappalController() {
        System.out.println("No arg const of chappal");
    }

    @RequestMapping("/chappal")
    public String addChappal(ChappalDTO chappalDTO, Model model) {
        System.out.println("Chappal brand"+chappalDTO.getBrand());
        System.out.println("Chappal price is :"+chappalDTO.getPrice());
        System.out.println("Added chappal to the cart");
        model.addAttribute("brand",chappalDTO.getBrand());
        model.addAttribute("price",chappalDTO.getPrice());
        return "chappal.jsp";
    }

}
