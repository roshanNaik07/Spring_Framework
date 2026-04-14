package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;

import java.util.List;

public interface SlotService {

    boolean saveSlotTime(SlotTimeDTO slotTimeDTO);

    List<DoctorRegistrationDTO> getDoctorDtoBySpecialization(String specialization);

    List<String> getAllSlotsBySpecialization(String Specialization);

    boolean saveDoctorSlots(String email,String slots);

}
