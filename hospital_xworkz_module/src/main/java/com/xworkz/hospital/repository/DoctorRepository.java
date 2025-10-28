package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorImageInfoEntity;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository {

    List<DoctorRegisterEntity> getAllDoctors();

    boolean updateDoctorDetails(DoctorRegisterEntity doctorRegisterEntity);

    boolean deleteDoctorByEmail(String email);

    DoctorRegisterEntity getDoctorByEmail(String email);

    DoctorRegisterEntity getDoctorById(int id);


}
