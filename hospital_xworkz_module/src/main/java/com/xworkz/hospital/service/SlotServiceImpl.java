package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.entity.SlotTimeEntity;
import com.xworkz.hospital.repository.SlotRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SlotServiceImpl implements SlotService{

    @Autowired
    SlotRepository slotRepository;

    public SlotServiceImpl(){
        log.info("Running SlotServiceImpl");
    }

    @Override
    public boolean saveSlotTime(SlotTimeDTO slotTimeDTO) {
        log.info("In service" + slotTimeDTO);
        SlotTimeEntity slotTimeEntity = new SlotTimeEntity();
        BeanUtils.copyProperties(slotTimeDTO, slotTimeEntity);
        return slotRepository.saveSlotTime(slotTimeEntity);
    }

    @Override
    public List<DoctorRegistrationDTO> getDoctorDtoBySpecialization(String specialization) {
        List<DoctorRegisterEntity> doctorRegisterEntities = slotRepository.getDoctorEntityBySpecialization(specialization);
        List<DoctorRegistrationDTO> doctorRegistrationDTOS = doctorRegisterEntities.stream().map(entity ->
                {
                    DoctorRegistrationDTO dto = new DoctorRegistrationDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                }
        ).collect(Collectors.toList());

        return doctorRegistrationDTOS;
    }

    @Override
    public List<String> getAllSlotsBySpecialization(String specialization) {
        List<SlotTimeEntity> slotTimeEntities = slotRepository.getAllSlotsBySpecialization(specialization);

        List<SlotTimeDTO> slotTimeDTOS = slotTimeEntities.stream().map(entity ->
                {
                    SlotTimeDTO dto = new SlotTimeDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                }
        ).collect(Collectors.toList());

        return slotTimeDTOS.stream()
                .map(dto -> dto.getSlotStartTime() + " - " + dto.getSlotEndTime())
                .collect(Collectors.toList());
    }

    @Override
    public boolean saveDoctorSlots(String email, String slots) {
        return slotRepository.saveDoctorSlots(email,slots);
    }
}
