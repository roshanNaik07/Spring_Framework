package com.xworkz.dominos.controller;

import com.xworkz.dominos.dto.DominosDto;
import com.xworkz.dominos.entity.DominosEntity;
import com.xworkz.dominos.service.DominoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class DominosController {

    @Autowired
    DominoService dominoService;

    public DominosController(){
        System.out.println("DominosController created by spring");
    }

    @RequestMapping("/order")
    public String saveData(@Valid DominosDto dto, BindingResult bindingResult, Model model){
        System.out.println("Running getFormDetails method");

        if (bindingResult.hasErrors()){
            System.out.println("Invalid data");
            List<ObjectError> objectErrors =  bindingResult.getAllErrors();

            for (ObjectError objectError : objectErrors){
                System.out.println(objectError.getDefaultMessage());
                model.addAttribute("error",objectError.getDefaultMessage());
                model.addAttribute("value",dto);
                return "Dominos";
            }
        }
        model.addAttribute("name",dto.getName());
        model.addAttribute("email",dto.getEmail());
        model.addAttribute("phoneNo",dto.getPhoneNo());
        model.addAttribute("price",dto.getPrice());
        boolean dataSaved = dominoService.saveData(dto);

        System.out.println(dataSaved);

        return "DominosResult";
    }

    @RequestMapping("/fetchDetails")
    public ModelAndView fetchDetails(ModelAndView modelAndView){

        System.out.println("Running fetchDetails in DominosController");

        List<DominosEntity> list = dominoService.fetchDetails();

        modelAndView.addObject("data",list);
        modelAndView.setViewName("FetchDetails");

        return modelAndView;
    }

    @RequestMapping("/getByID")
    public ModelAndView getById(@Valid DominosDto dominosDto , BindingResult bindingResult ,ModelAndView modelAndView){

        System.out.println("Running getById method in DominosController");

        if (bindingResult.hasErrors()){
            List<ObjectError> error = bindingResult.getAllErrors();
            for (ObjectError ref : error){
                if (ref.getDefaultMessage().equals("id cannot be negative or zero")){
                    System.out.println("Data is invalid");
                    modelAndView.addObject("error",ref.getDefaultMessage());
                    modelAndView.setViewName("SearchId");
                    return modelAndView;
                }
            }
        }

        DominosDto dto = dominoService.getById(dominosDto.getId());

        modelAndView.addObject("result",dto);

        modelAndView.setViewName("SearchId");
        return modelAndView;
    }
}
