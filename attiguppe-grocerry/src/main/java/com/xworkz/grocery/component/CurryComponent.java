package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class CurryComponent {

    public CurryComponent(){
        System.out.println("No arg const of CurryComponent");
    }

    @RequestMapping("/curry")
    public String addCurry(){
        System.out.println("Curry added to the cart");
        return "curry.jsp";
    }
}
