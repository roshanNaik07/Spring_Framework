package com.xworkz.grocery.component;

import com.xworkz.grocery.dto.BottleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class BottleController {

    public BottleController(){
        System.out.println("no arg const of BottleComponent");
    }

    @RequestMapping("/bottle")
    public ModelAndView addBottle(BottleDTO bottleDTO, ModelAndView modelAndView){
        System.out.println("Bottle color : "+bottleDTO.getColor());
        System.out.println("Bottle price : "+bottleDTO.getPrice());
        System.out.println("Added bottle to the cart");
        modelAndView.addObject("color",bottleDTO.getColor());
        modelAndView.addObject("price",bottleDTO.getPrice());
        modelAndView.setViewName("bottle.jsp");
        return modelAndView;
    }

}
