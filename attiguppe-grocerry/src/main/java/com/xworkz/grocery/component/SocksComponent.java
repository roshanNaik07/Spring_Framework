package com.xworkz.grocery.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class SocksComponent {

    public SocksComponent(){
        System.out.println("Running no arg const of SocksComponent");
    }

    @RequestMapping("/socks")
    public String addSocks(@RequestParam("brand") String brand,@RequestParam("price") int price){
        System.out.println("Socks brand is : "+brand);
        System.out.println("Socks price is : "+price);
        System.out.println("Socks added to the cart");
        return "socks.jsp";
    }
}
