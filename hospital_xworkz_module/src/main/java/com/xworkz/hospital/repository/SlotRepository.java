package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.entity.SlotTimeEntity;

import java.util.List;

public interface SlotRepository {

    boolean saveSlotTime(SlotTimeEntity slotTimeEntity);

    List<DoctorRegisterEntity> getDoctorEntityBySpecialization(String specialization);

    List<SlotTimeEntity> getAllSlotsBySpecialization(String Specialization);

    boolean saveDoctorSlots(String email,String slots);

}
