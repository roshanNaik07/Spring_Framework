package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.repository.DoctorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<DoctorRegistrationDTO> getAllDoctors() {
        List<DoctorRegisterEntity> doctorRegisterEntities = doctorRepository.getAllDoctors();
        if (doctorRegisterEntities != null && !doctorRegisterEntities.isEmpty()) {
            return doctorRegisterEntities.stream().map(entity -> {
                DoctorRegistrationDTO dto = new DoctorRegistrationDTO();
                BeanUtils.copyProperties(entity, dto);
                return dto;
            }).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public boolean updateDoctorDetails(DoctorRegistrationDTO doctorRegistrationDTO) {
        DoctorRegisterEntity doctorRegisterEntity = new DoctorRegisterEntity();
        BeanUtils.copyProperties(doctorRegistrationDTO,doctorRegisterEntity);
        return doctorRepository.updateDoctorDetails(doctorRegisterEntity);
    }

    @Override
    public boolean deleteDoctorByEmail(String email) {
        return doctorRepository.deleteDoctorByEmail(email);
    }
}
