package com.xworkz.hospital.service;

import com.xworkz.hospital.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<String> getAllBloodGroups() {
        log.info("Running getAllBloodGroups in PatientServiceImpl");
        List<String> bloodGroups = patientRepository.getAllBloodGroups();
        if (bloodGroups != null && !bloodGroups.isEmpty()) {
            return bloodGroups;
        }
        return Collections.emptyList();
    }

}
