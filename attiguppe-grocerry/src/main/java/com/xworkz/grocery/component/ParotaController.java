package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ParotaDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ParotaController {

    public ParotaController(){
        System.out.println("no arg const of ParotaComponent");
    }

    @RequestMapping("/parota")
    public String adaParota(ParotaDTO parotaDTO , Model model){
        System.out.println("Parota type is : "+parotaDTO.getType());
        System.out.println("Parota price is : "+parotaDTO.getPrice());
        System.out.println("Parota added to the cart");

        model.addAttribute("type",parotaDTO.getType());
        model.addAttribute("price",parotaDTO.getPrice());
        return "parota.jsp";
    }

}
