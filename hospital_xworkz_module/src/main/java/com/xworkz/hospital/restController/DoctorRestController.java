package com.xworkz.hospital.restController;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class DoctorRestController {

    @Autowired
    private DoctorService doctorService;

    DoctorRestController() {
        log.info("Running No argument constructor of DoctorRestController");
    }

    @GetMapping("/checkExistingDoctorEmail")
    public String checkEmailExists(@RequestParam String email) {

        DoctorRegistrationDTO dto = doctorService.getDoctorByEmail(email);

        if (dto != null) {
            return "exists";
        }
        return "not_exists";
    }

    @GetMapping("/checkExistingPhoneNumber")
    public String checkPhoneNumberExists(@RequestParam String phoneNumber) {
        log.info(phoneNumber);
        DoctorRegistrationDTO doctorRegistrationDTO = doctorService.getDoctorByPhoneNumber(phoneNumber);
        System.out.println(doctorRegistrationDTO);
        if (doctorRegistrationDTO != null){
            return "Invalid";
        }
        return "valid";
    }

}
