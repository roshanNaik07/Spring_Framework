package com.xworkz.hospital.repository;

import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.entity.SlotTimeEntity;
import com.xworkz.hospital.entity.SpecializationEntity;

import java.util.List;

public interface AdminRepository {

    String sendOTP(String email);

    boolean checkEmail(String email);

    boolean registerDoctor(DoctorRegisterEntity doctorRegisterEntity);

    boolean saveSlotTime(SlotTimeEntity slotTimeEntity);

    List<DoctorRegisterEntity> getDoctorEntityBySpecialization(String specialization);

    void addSpecialization(SpecializationEntity specializationEntity);

    List<String> getAllSpecializations();

    List<SlotTimeEntity> getAllSlotsBySpecialization(String Specialization);

    boolean saveDoctorSlots(String email,String slots);
}
