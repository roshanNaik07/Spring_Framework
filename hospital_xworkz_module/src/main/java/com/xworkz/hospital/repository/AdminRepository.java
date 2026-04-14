package com.xworkz.hospital.repository;

import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.entity.DoctorTimeSlotEntity;
import com.xworkz.hospital.entity.SlotTimeEntity;
import com.xworkz.hospital.entity.SpecializationEntity;

import java.util.List;

public interface AdminRepository {

    String sendOTP(String email);

    boolean checkEmail(String email);

    List<DoctorTimeSlotEntity> getDoctorTimeSlotEntitiesById(int id);

    DoctorTimeSlotEntity getDoctorTimeSlotEntityById(int id);

}
