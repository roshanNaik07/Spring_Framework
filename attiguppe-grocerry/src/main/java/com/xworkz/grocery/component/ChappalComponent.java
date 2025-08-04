package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ChappalComponent {

    public ChappalComponent(){
        System.out.println("No arg const of chappal");
    }

    @RequestMapping("/chappal")
    public String addChappal(){
        System.out.println("Added chappal to the cart");
        return "chappal.jsp";
    }

}
