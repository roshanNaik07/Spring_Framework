package com.xworkz.hospital.repository;

import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.entity.SlotTimeEntity;

public interface AdminRepository {

    String sendOTP(String email);

    boolean checkEmail(String email);

    boolean registerDoctor(DoctorRegisterEntity doctorRegisterEntity);

    boolean saveSlotTime(SlotTimeEntity slotTimeEntity);
}
