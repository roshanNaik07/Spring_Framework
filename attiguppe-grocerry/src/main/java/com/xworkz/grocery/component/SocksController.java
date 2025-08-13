package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.SocksDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class SocksController {

    public SocksController(){
        System.out.println("Running no arg const of SocksComponent");
    }

    @RequestMapping("/socks")
    public String addSocks(SocksDTO socksDTO , Model model){
        System.out.println("Socks brand is : "+socksDTO.getBrand());
        System.out.println("Socks price is : "+socksDTO.getPrice());
        System.out.println("Socks added to the cart");
        model.addAttribute("brand",socksDTO.getBrand());
        model.addAttribute("price",socksDTO.getPrice());
        return "socks.jsp";
    }
}
