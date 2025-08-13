package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.SoapDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class SoapController {

    public SoapController(){
        System.out.println("Running no arg const of SoapComponent");
    }

    @RequestMapping("/soap")
    public String getSoap(SoapDTO soapDTO, Model model){
        System.out.println("Soap brand is : "+soapDTO.getBrand());
        System.out.println("Soap price is : "+soapDTO.getPrice());
        System.out.println("Soap added to the Cart");
        model.addAttribute("brand",soapDTO.getBrand());
        model.addAttribute("price",soapDTO.getPrice());
        return "soap.jsp";
    }
}
