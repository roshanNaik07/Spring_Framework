package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.entity.DoctorImageInfoEntity;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<DoctorRegistrationDTO> getAllDoctors() {
        List<DoctorRegisterEntity> doctorRegisterEntities = doctorRepository.getAllDoctors();
        if (doctorRegisterEntities != null && !doctorRegisterEntities.isEmpty()) {
            return doctorRegisterEntities.stream().map(entity -> {
                DoctorRegistrationDTO dto = new DoctorRegistrationDTO();
                BeanUtils.copyProperties(entity, dto);
                dto.setImageName(entity.getDoctorImageInfo().getImageName());
                return dto;
            }).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public boolean updateDoctorDetails(DoctorRegistrationDTO doctorRegistrationDTO, MultipartFile multipartFile) throws IOException {
        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get("D:\\Hospital\\" + doctorRegistrationDTO.getName() + System.currentTimeMillis() + ".jpg");
        Files.write(path, bytes);

        DoctorRegisterEntity doctorRegisterEntity = doctorRepository.getDoctorByEmail(doctorRegistrationDTO.getEmail());
        log.info("In service before update" + doctorRegisterEntity);
        doctorRegisterEntity.setName(doctorRegistrationDTO.getName());
        doctorRegisterEntity.setSpecialization(doctorRegistrationDTO.getSpecialization());
        doctorRegisterEntity.setQualification(doctorRegistrationDTO.getQualification());
        doctorRegisterEntity.setExperience(doctorRegistrationDTO.getExperience());
        doctorRegisterEntity.setPhoneNumber(doctorRegistrationDTO.getPhoneNumber());

        DoctorImageInfoEntity image = doctorRegisterEntity.getDoctorImageInfo();
        image.setImageName(path.getFileName().toString());
        image.setOriginalImageName(multipartFile.getOriginalFilename());
        image.setImageSize(multipartFile.getSize());
        image.setImagePath(path.toString());

        image.setDoctor(doctorRegisterEntity);
        doctorRegisterEntity.setDoctorImageInfo(image);

        log.info("In service after update" + doctorRegisterEntity);
        return doctorRepository.updateDoctorDetails(doctorRegisterEntity);
    }

    @Override
    public boolean deleteDoctorByEmail(String email) {
        return doctorRepository.deleteDoctorByEmail(email);
    }
}
