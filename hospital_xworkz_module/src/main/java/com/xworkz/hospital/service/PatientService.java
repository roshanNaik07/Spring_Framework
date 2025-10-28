package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.PatientRegistrationDTO;

import java.util.List;

public interface PatientService {

    List<String> getAllBloodGroups();

    boolean patientRegistration(PatientRegistrationDTO patientRegistrationDTO);
}
