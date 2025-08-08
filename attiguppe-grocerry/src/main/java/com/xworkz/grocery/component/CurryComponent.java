package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.CurryDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class CurryComponent {

    public CurryComponent(){
        System.out.println("No arg const of CurryComponent");
    }

    @RequestMapping("/curry")
    public String addCurry(CurryDTO curryDTO){

        System.out.println("Curry type is : "+curryDTO.getType());
        System.out.println("Curry price is :"+curryDTO.getPrice());
        System.out.println("Curry added to the cart");
        return "curry.jsp";
    }
}
