package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.BiryaniDTO;
import com.xworkz.grocery.dto.ShoeDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class SoapComponent {

    public SoapComponent(){
        System.out.println("Running no arg const of SoapComponent");
    }

    @RequestMapping("/soap")
    public String getSoap(ShoeDTO shoeDTO){
        System.out.println("Soap brand is : "+shoeDTO.getBrand());
        System.out.println("Soap price is : "+shoeDTO.getPrice());
        System.out.println("Soap added to the Cart");
        return "soap.jsp";
    }
}
