package com.xworkz.travel.Controller;

import com.xworkz.travel.dto.StudentDto;
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
public class StudentController {

    public StudentController(){
        System.out.println("StudentController created by spring");
    }

    @Autowired
    TravelService travelService ;

    @RequestMapping("/student")
    public ModelAndView saveData(@Valid StudentDto studentDto ,BindingResult bindingResult , ModelAndView modelAndView){
        System.out.println("Running saveData");
        modelAndView.setViewName("Student");
        if (bindingResult.hasErrors()){
            System.out.println("Invalid data");
            List<ObjectError> list = bindingResult.getAllErrors();
            for (ObjectError error : list){
                modelAndView.addObject("error",error.getDefaultMessage());
                modelAndView.addObject("value",studentDto);
                return modelAndView;
            }
        }
        travelService.saveStudentData(studentDto);
        modelAndView.addObject("Result","Data Saved successfully");
        return modelAndView;
    }
}
