package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ChutneyDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ChutneyController {

    public ChutneyController(){
        System.out.println("Running no arg const of Chutney");
    }

    @RequestMapping("/chutney")
    public String addChutney(ChutneyDTO chutneyDTO, Model model){

        System.out.println("Chutney main item :"+chutneyDTO.getItem());
        System.out.println("Chutney Price :"+chutneyDTO.getPrice());

        System.out.println("Chutney added to the cart");
        model.addAttribute("item",chutneyDTO.getItem());
        model.addAttribute("price",chutneyDTO.getPrice());

        return "chutney.jsp";
    }

}
