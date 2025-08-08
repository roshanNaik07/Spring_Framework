package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.SocksDTO;
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
    public String addSocks(SocksDTO socksDTO){
        System.out.println("Socks brand is : "+socksDTO.getBrand());
        System.out.println("Socks price is : "+socksDTO.getPrice());
        System.out.println("Socks added to the cart");
        return "socks.jsp";
    }
}
