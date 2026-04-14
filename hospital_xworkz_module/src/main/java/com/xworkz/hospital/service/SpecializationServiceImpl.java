package com.xworkz.hospital.service;

import com.xworkz.hospital.entity.SpecializationEntity;
import com.xworkz.hospital.repository.SpecializationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SpecializationServiceImpl implements SpecializationService{

    @Autowired
    SpecializationRepository specializationRepository;

    @Override
    public boolean addSpecialization(String specialization) {

        if (specialization == null || specialization.trim().isEmpty()) {
            log.info("Specialization is invalid");
            return false;
        }
        try {
            SpecializationEntity specializationEntity = new SpecializationEntity();
            specializationEntity.setSpecialization(specialization.trim());
            specializationRepository.addSpecialization(specializationEntity);
            log.info("Specialization added successfully");
            return true;
        } catch (Exception e) {
            log.info("Error while adding specialization: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<String> getAllSpecializations() {
        return specializationRepository.getAllSpecializations();
    }

}
