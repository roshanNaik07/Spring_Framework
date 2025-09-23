package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.service.AdminService;
import com.xworkz.hospital.service.DoctorService;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    AdminService adminService;

    public DoctorController() {
        System.out.println("No arg const of DoctorController");
    }

    @GetMapping("/getAllDotors")
    public ModelAndView getAllDoctors(ModelAndView modelAndView) {
        List<DoctorRegistrationDTO> doctorRegistrationDTOS = doctorService.getAllDoctors();
        modelAndView.addObject("doctors", doctorRegistrationDTOS);
        modelAndView.setViewName("Doctors");
        return modelAndView;
    }

    @PostMapping("/openUpdateDoctorPage")
    public ModelAndView openUpdateDoctorPage(@Valid DoctorRegistrationDTO doctorRegistrationDTO, BindingResult bindingResult, ModelAndView modelAndView) {
        List<String> specializations = adminService.getAllSpecializations();
        modelAndView.addObject("values", doctorRegistrationDTO);
        modelAndView.addObject("specializations", specializations);
        modelAndView.setViewName("UpdateDoctor");
        return modelAndView;
    }

    @PostMapping("/updateDoctorDetails")
    public ModelAndView updateDoctorDetails(@RequestParam("image") MultipartFile multipartFile, @Valid DoctorRegistrationDTO doctorRegistrationDTO, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {

        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get("D:\\Hospital\\" + doctorRegistrationDTO.getName() + System.currentTimeMillis() + ".jpg");
        Files.write(path, bytes);
        String imageName = path.getFileName().toString();
        doctorRegistrationDTO.setImageName(imageName);

        List<String> specializations = adminService.getAllSpecializations();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
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
            boolean saved = doctorService.updateDoctorDetails(doctorRegistrationDTO);
            if (saved) {
                modelAndView.addObject("success", "Doctor details updated successfully");
                modelAndView.setViewName("Admin");
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
