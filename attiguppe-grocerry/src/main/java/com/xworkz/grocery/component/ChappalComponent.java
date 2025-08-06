package com.xworkz.grocery.component;

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
    public String addChappal(@RequestParam("brand") String brand , @RequestParam("price") int price) {
        System.out.println("Chappal brand"+brand);
        System.out.println("Chappal price is :"+price);
        System.out.println("Added chappal to the cart");
        return "chappal.jsp";
    }

}
