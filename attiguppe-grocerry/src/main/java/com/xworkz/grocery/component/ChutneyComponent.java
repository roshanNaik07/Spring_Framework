package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ChutneyComponent {

    public ChutneyComponent(){
        System.out.println("Running no arg const of Chutney");
    }

    @RequestMapping("/chutney")
    public String addChutney(){
        System.out.println("Chutney added to the cart");
        return "chutney.jsp";
    }

}
