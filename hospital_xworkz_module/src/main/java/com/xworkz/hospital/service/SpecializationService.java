package com.xworkz.hospital.service;

import java.util.List;

public interface SpecializationService {

    boolean addSpecialization(String specialization);

    List<String> getAllSpecializations();

}
