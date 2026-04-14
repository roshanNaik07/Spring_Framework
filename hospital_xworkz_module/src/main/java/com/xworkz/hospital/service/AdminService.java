package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.DoctorTimeSlotDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.entity.DoctorTimeSlotEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean sendOTP(String email);

    boolean verifyOTP(String otp);

    boolean checkEmail(String email);

    List<DoctorTimeSlotDTO> getDoctorTimeSlotDtoById(int id);

    DoctorTimeSlotEntity getDoctorTimeSlotEntityById(int id);
}
