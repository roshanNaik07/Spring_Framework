package com.xworkz.travel.Controller;

import com.xworkz.travel.dto.BgmiDto;
import com.xworkz.travel.service.TravelService;
import com.xworkz.travel.service.TravelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class BgmiController {

    @Autowired
    TravelService travelService;

    public BgmiController(){
        System.out.println("BgmiController is created by spring");
    }

    @RequestMapping("/bgmi")
    public ModelAndView saveBgmiData(BgmiDto dto,ModelAndView modelAndView){
        System.out.println("Running saveBgmiData BgmiController");

        boolean result = travelService.saveBgmiData(dto);
        System.out.println(result);
        modelAndView.setViewName("Bgmi.jsp");
        return modelAndView;
    }
}
