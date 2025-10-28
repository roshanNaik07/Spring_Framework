package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.PatientRegisterEntity;

import java.util.List;

public interface PatientRepository {

    List<String> getAllBloodGroups();

    boolean registerPatient(PatientRegisterEntity patientRegisterEntity);
}
