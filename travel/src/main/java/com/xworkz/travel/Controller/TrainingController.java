package com.xworkz.travel.Controller;

import com.xworkz.travel.dto.TrainingDto;
import com.xworkz.travel.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TrainingController {

    @Autowired
    TravelService travelService ;

    public TrainingController(){
        System.out.println("TrainingController created by spring");
    }

    @RequestMapping("/training")
    public ModelAndView saveTrainingData(@Valid TrainingDto trainingDto , BindingResult bindingResult , ModelAndView modelAndView){
        System.out.println("Running saveTrainingData");
        if (bindingResult.hasErrors()){
            System.out.println("Invalid data");
            List<ObjectError> list = bindingResult.getAllErrors();
            for (ObjectError error : list){
                System.out.println(error.getDefaultMessage());
                modelAndView.addObject("error",error.getDefaultMessage());
                modelAndView.addObject("value",trainingDto);
                modelAndView.setViewName("Training");
                return modelAndView;
            }
        }
        travelService.saveTrainingData(trainingDto);
        modelAndView.addObject("Result","Data Saved successfully");
        modelAndView.setViewName("Training");
        return modelAndView;
    }

}
