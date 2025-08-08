package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.ParotaDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class ParotaComponent {

    public ParotaComponent(){
        System.out.println("no arg const of ParotaComponent");
    }

    @RequestMapping("/parota")
    public String adaParota(ParotaDTO parotaDTO){
        System.out.println("Parota type is : "+parotaDTO.getType());
        System.out.println("Parota price is : "+parotaDTO.getPrice());
        System.out.println("Parota added to the cart");
        return "parota.jsp";
    }

}
