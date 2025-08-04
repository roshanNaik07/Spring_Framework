package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class SoapComponent {

    public SoapComponent(){
        System.out.println("Running no arg const of SoapComponent");
    }

    @RequestMapping("/soap")
    public String getSoap(){
        System.out.println("Soap added to the Cart");
        return "soap.jsp";
    }
}
