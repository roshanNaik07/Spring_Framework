package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ChutneyDTO;
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
    public String addChutney(ChutneyDTO chutneyDTO){

        System.out.println("Chutney main item :"+chutneyDTO.getItem());
        System.out.println("Chutney Price :"+chutneyDTO.getPrice());

        System.out.println("Chutney added to the cart");
        return "chutney.jsp";
    }

}
