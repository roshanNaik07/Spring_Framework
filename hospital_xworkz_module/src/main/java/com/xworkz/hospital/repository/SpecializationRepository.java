package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.SpecializationEntity;

import java.util.List;

public interface SpecializationRepository {

    void addSpecialization(SpecializationEntity specializationEntity);

    List<String> getAllSpecializations();

}
