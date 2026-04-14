package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.service.AdminService;
import com.xworkz.hospital.service.DoctorService;
import com.xworkz.hospital.service.SpecializationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    AdminService adminService;

    @Autowired
    SpecializationService specializationService;

    public DoctorController() {
        log.info("No arg const of DoctorController");
    }

    @RequestMapping("/doctorRegistration")
    public ModelAndView openDoctorRegistrationPage(ModelAndView modelAndView) {
        log.info("Opening doctor registration page");
        List<String> specializations = specializationService.getAllSpecializations();
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("RegisterDoctor");
        return modelAndView;
    }

    @PostMapping("/registerDoctor")
    public ModelAndView registerDoctor(@RequestParam("image") MultipartFile multipartFile, @Valid DoctorRegistrationDTO doctorRegistrationDTO, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {

        List<String> specializations = specializationService.getAllSpecializations();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                log.info(error.getDefaultMessage());
                modelAndView.addObject("error", error.getDefaultMessage());
                modelAndView.addObject("specializations", specializations);
                modelAndView.addObject("values", doctorRegistrationDTO);
                modelAndView.setViewName("RegisterDoctor");
            }
        } else if (multipartFile.isEmpty()) {
            modelAndView.addObject("error", "Please upload the image");
            modelAndView.addObject("specializations", specializations);
            modelAndView.addObject("values", doctorRegistrationDTO);
            modelAndView.setViewName("RegisterDoctor");
        } else {
            boolean registered = doctorService.registerDoctor(doctorRegistrationDTO, multipartFile);
            if (registered) {
                modelAndView.addObject("success", "Doctor registered successfully");
                modelAndView.setViewName("Admin");
            } else {
                modelAndView.addObject("error", "Failed to register doctor");
                modelAndView.addObject("specializations", specializations);
                modelAndView.addObject("values", doctorRegistrationDTO);
                modelAndView.setViewName("RegisterDoctor");
            }
        }
        return modelAndView;
    }

    @GetMapping("/doctors")
    public ModelAndView getAllDoctors(ModelAndView modelAndView) {
        List<DoctorRegistrationDTO> doctorRegistrationDTOS = doctorService.getAllDoctors();
        modelAndView.addObject("doctors", doctorRegistrationDTOS);
        modelAndView.setViewName("Doctors");
        return modelAndView;
    }

    @PostMapping("/updateDoctor")
    public ModelAndView openUpdateDoctorPage(@Valid DoctorRegistrationDTO doctorRegistrationDTO, BindingResult bindingResult, ModelAndView modelAndView) {
        List<String> specializations = specializationService.getAllSpecializations();
        modelAndView.addObject("values", doctorRegistrationDTO);
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("UpdateDoctor");
        return modelAndView;
    }

    @PostMapping("/doctorUpdated")
    public ModelAndView updateDoctorDetails(@RequestParam("image") MultipartFile multipartFile, @Valid DoctorRegistrationDTO doctorRegistrationDTO, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {

        List<String> specializations = specializationService.getAllSpecializations();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                log.info(error.getDefaultMessage());
                modelAndView.addObject("error", error.getDefaultMessage());
                modelAndView.addObject("specializations", specializations);
                modelAndView.addObject("values", doctorRegistrationDTO);
                modelAndView.setViewName("UpdateDoctor");
            }
        } else if (multipartFile.isEmpty()) {
            modelAndView.addObject("error", "Please upload the image");
            modelAndView.addObject("specializations", specializations);
            modelAndView.addObject("values", doctorRegistrationDTO);
            modelAndView.setViewName("UpdateDoctor");
        } else {
            boolean saved = doctorService.updateDoctorDetails(doctorRegistrationDTO,multipartFile);
            if (saved) {
                List<DoctorRegistrationDTO> doctorRegistrationDTOS = doctorService.getAllDoctors();
                modelAndView.addObject("doctors", doctorRegistrationDTOS);
                modelAndView.setViewName("Doctors");
            } else {
                modelAndView.addObject("error", "Failed to update doctor details");
                modelAndView.addObject("specializations", specializations);
                modelAndView.addObject("values", doctorRegistrationDTO);
                modelAndView.setViewName("UpdateDoctor");
            }
        }
        return modelAndView;
    }

    @RequestMapping("/deleteDoctor")
    public ModelAndView deleteDoctorByEmail(@RequestParam String email, ModelAndView modelAndView) {

        boolean deleted = doctorService.deleteDoctorByEmail(email);
        if (deleted) {
            modelAndView.addObject("success", "Doctor deleted successfully");
            List<DoctorRegistrationDTO> doctorRegistrationDTOS = doctorService.getAllDoctors();
            modelAndView.addObject("doctors", doctorRegistrationDTOS);
            modelAndView.setViewName("Doctors");
        } else {
            modelAndView.addObject("error", "Failed to delete doctor");
        }
        return modelAndView;

    }

    @GetMapping("/download")
    public void getImage(HttpServletResponse response, @RequestParam String fileName) throws IOException {
        response.setContentType("image/jpg");
        File file = new File("D:\\Hospital\\" + fileName);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream servletOutputStream = response.getOutputStream();
        IOUtils.copy(inputStream, servletOutputStream);

        response.flushBuffer();
    }

}
