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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getById(@RequestParam int id ,ModelAndView modelAndView){

        System.out.println("Running getById method in DominosController");

        if (id == 0){
            System.out.println("Data is invalid");
            modelAndView.addObject("error","Id cannot be 0 or negative");
            modelAndView.setViewName("SearchId");
            return modelAndView;
        }

        DominosDto dto = dominoService.getById(id);

        modelAndView.addObject("result",dto);

        modelAndView.setViewName("SearchId");
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView updateById(@Valid DominosDto dto , BindingResult bindingResult ,ModelAndView modelAndView,@RequestParam int id){
        System.out.println("Running updateById in DominosController");

        if (id == 0){
            modelAndView.addObject("error","Id cannot be zero");
            modelAndView.setViewName("Update");
            return modelAndView;
        }

        if (bindingResult.hasErrors()){
                List<ObjectError> objectErrors = bindingResult.getAllErrors();
                for (ObjectError objectError : objectErrors){
                    modelAndView.addObject("value",dto);
                    modelAndView.addObject("error",objectError.getDefaultMessage());
                    modelAndView.setViewName("Update");
                    return modelAndView;
            }
        }

        boolean result = dominoService.updateById(id,dto);
        if (result!=false){
            modelAndView.addObject("updated","successfully updated");
        }else {
            modelAndView.addObject("error","Id does not exist");
        }
        modelAndView.setViewName("Update");
        return modelAndView;
    }

    @RequestMapping("/deleteId")
    public ModelAndView deleteId(@RequestParam int id,ModelAndView modelAndView){
        System.out.println("Running deleteId in DominosController");
        if (id == 0){
            modelAndView.addObject("error","Id cannot be zero");
            modelAndView.setViewName("Delete");
            return modelAndView;
        }

        boolean result = dominoService.deleteById(id);
        System.out.println(result);
        if (result!=false){
            modelAndView.addObject("deleted","Entity deleted successfully");
        }else {
            modelAndView.addObject("error","Id does not exist");
        }

        modelAndView.setViewName("Delete");
        return modelAndView;
    }

    @RequestMapping("/checkDomain")
    public ModelAndView checkDomain(@RequestParam String domain ,ModelAndView modelAndView){

        System.out.println("Running checkDomain in DominosController");

        if(domain == null){
            modelAndView.addObject("error","please enter the domain to search");
            modelAndView.setViewName("DomainCheck");
            return modelAndView;
        }

        List<DominosEntity> list = dominoService.getDomainList(domain);
        if (list.isEmpty()){
            System.out.println("List is empty");
        }
        modelAndView.addObject("data",list);
        modelAndView.setViewName("DomainCheck");
        return modelAndView;
    }

    @RequestMapping("/getNames")
    public ModelAndView getNameAbovePrice(@RequestParam int price,ModelAndView modelAndView){
        System.out.println("Running getNameAbovePhoneNo in DominosController");

        if (price <=100 || price >=300){
            System.out.println("Invalid price check");
            modelAndView.addObject("error","Enter price between 100 - 300");
            modelAndView.setViewName("PriceDetails");
            return modelAndView;
        }

        List<String> names = dominoService.getNameAbovePrice(price);
        if (names.isEmpty()){
            modelAndView.addObject("error","No details found for this price");
            modelAndView.setViewName("PriceDetails");
            return modelAndView;
        }
        modelAndView.addObject("data",names);
        modelAndView.setViewName("PriceDetails");
        return modelAndView;
    }
}
