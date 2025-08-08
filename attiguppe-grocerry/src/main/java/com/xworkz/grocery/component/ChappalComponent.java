package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ChappalDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ChappalComponent {

    public ChappalComponent() {
        System.out.println("No arg const of chappal");
    }

    @RequestMapping("/chappal")
    public String addChappal(ChappalDTO chappalDTO) {
        System.out.println("Chappal bran"+chappalDTO.getBrand());
        System.out.println("Chappal price is :"+chappalDTO.getPrice());
        System.out.println("Added chappal to the cart");
        return "chappal.jsp";
    }

}
