package com.xworkz.hospital.restController;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.DoctorTimeSlotDTO;
import com.xworkz.hospital.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class PatientRestController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "fetchDoctorNameBySpecialization/{specialization}",produces = "application/json")
    public List<DoctorRegistrationDTO> fetchDoctorNameBySpecialization(@PathVariable String specialization) {
        log.info("Running fetchDoctorNameBySpecialization...");
        List<DoctorRegistrationDTO> doctorRegistrationDTOS = adminService.getDoctorDtoBySpecialization(specialization);
        return (doctorRegistrationDTOS != null) ? doctorRegistrationDTOS : Collections.emptyList();
    }

    @GetMapping(value = "fetchSlotsByDoctorId/{doctorId}",produces = "application/json")
    public List<DoctorTimeSlotDTO> fetchTimeSlotsByDoctorId(@PathVariable int doctorId) {
        List<DoctorTimeSlotDTO> doctorSlots = adminService.getDoctorTimeSlotDtoById(doctorId);
        log.info("Running fetchTimeSlotsByDoctorId..."+doctorSlots);
        return (doctorSlots != null)? doctorSlots : Collections.emptyList();

    }

}
