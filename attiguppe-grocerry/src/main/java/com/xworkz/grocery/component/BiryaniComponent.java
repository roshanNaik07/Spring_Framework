package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.BiryaniDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BiryaniComponent {

    public BiryaniComponent(){
        System.out.println("No arg const of BiryaniComponent");
    }

    @RequestMapping("/biryani")
    public String addBiryani(BiryaniDTO biryaniDTO){
        System.out.println("Type is : "+biryaniDTO.getBiryaniType());
        System.out.println("Price is : "+biryaniDTO.getPrice());
        System.out.println("Biryani added to the cart");
        return "biryani.jsp";
    }

}
