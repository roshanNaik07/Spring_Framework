package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DoctorService {

    List<DoctorRegistrationDTO> getAllDoctors();

    boolean updateDoctorDetails(DoctorRegistrationDTO doctorRegistrationDTO, MultipartFile multipartFile) throws IOException;

    boolean deleteDoctorByEmail(String email);
}
