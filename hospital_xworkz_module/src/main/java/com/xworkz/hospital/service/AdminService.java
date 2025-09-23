package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;
import java.util.List;

public interface AdminService {

    boolean sendOTP(String email);

    boolean verifyOTP(String otp);

    boolean checkEmail(String email);

    boolean registerDoctor(DoctorRegistrationDTO doctorRegistrationDTO);

    boolean saveSlotTime(SlotTimeDTO slotTimeDTO);

    List<DoctorRegistrationDTO> getDoctorDtoBySpecialization(String specialization);

    List<String> getAllSlotsBySpecialization(String Specialization);

    boolean addSpecialization(String specialization);

    List<String> getAllSpecializations();

    boolean saveDoctorSlots(String email,String slots);
}
