package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.DoctorTimeSlotDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean sendOTP(String email);

    boolean verifyOTP(String otp);

    boolean checkEmail(String email);

    boolean registerDoctor(DoctorRegistrationDTO doctorRegistrationDTO, MultipartFile multipartFile) throws IOException;

    boolean saveSlotTime(SlotTimeDTO slotTimeDTO);

    List<DoctorRegistrationDTO> getDoctorDtoBySpecialization(String specialization);

    List<String> getAllSlotsBySpecialization(String Specialization);

    boolean addSpecialization(String specialization);

    List<String> getAllSpecializations();

    boolean saveDoctorSlots(String email,String slots);

    List<DoctorTimeSlotDTO> getDoctorTimeSlotDtoById(int id);
}
