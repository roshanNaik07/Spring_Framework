package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class SocksComponent {

    public SocksComponent(){
        System.out.println("Running no arg const of SocksComponent");
    }

    @RequestMapping("/socks")
    public String addSocks(){
        System.out.println("Socks added to the cart");
        return "socks.jsp";
    }
}
