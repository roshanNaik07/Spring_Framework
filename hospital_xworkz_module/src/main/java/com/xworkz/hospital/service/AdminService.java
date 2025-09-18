package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;

public interface AdminService {

    boolean sendOTP(String email);

    boolean verifyOTP(String otp);

    boolean checkEmail(String email);

    boolean registerDoctor(DoctorRegistrationDTO doctorRegistrationDTO);

    boolean saveSlotTime(SlotTimeDTO slotTimeDTO);

    boolean getDoctorBySpecialization(String specialization);
}
