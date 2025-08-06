package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ChutneyComponent {

    public ChutneyComponent(){
        System.out.println("Running no arg const of Chutney");
    }

    @RequestMapping("/chutney")
    public String addChutney(@RequestParam ("item") String item,@RequestParam ("price") int price){

        System.out.println("Chutney main item :"+item);
        System.out.println("Chutney Price :"+price);

        System.out.println("Chutney added to the cart");
        return "chutney.jsp";
    }

}
