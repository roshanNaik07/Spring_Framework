package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.BiryaniDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BiryaniController {

    public BiryaniController(){
        System.out.println("No arg const of BiryaniComponent");
    }

    @RequestMapping("/biryani")
    public String addBiryani(BiryaniDTO biryaniDTO, Model model){
        System.out.println("Type is : "+biryaniDTO.getBiryaniType());
        System.out.println("Price is : "+biryaniDTO.getPrice());
        System.out.println("Biryani added to the cart");

        model.addAttribute("type",biryaniDTO);
        model.addAttribute("price",biryaniDTO.getPrice());

        return "biryani.jsp";
    }

}
