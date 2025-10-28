    package com.xworkz.hospital.service;

    import com.xworkz.hospital.dto.PatientRegistrationDTO;
    import com.xworkz.hospital.entity.DoctorRegisterEntity;
    import com.xworkz.hospital.entity.DoctorTimeSlotEntity;
    import com.xworkz.hospital.entity.PatientRegisterEntity;
    import com.xworkz.hospital.repository.PatientRepository;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.BeanUtils;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.stereotype.Service;

    import java.util.Collections;
    import java.util.List;

    @Service
    @Slf4j
    public class PatientServiceImpl implements PatientService {

        @Autowired
        PatientRepository patientRepository;

        @Autowired
        DoctorService doctorService;

        @Autowired
        AdminService adminService;

        @Override
        public List<String> getAllBloodGroups() {
            log.info("Running getAllBloodGroups in PatientServiceImpl");
            List<String> bloodGroups = patientRepository.getAllBloodGroups();
            if (bloodGroups != null && !bloodGroups.isEmpty()) {
                return bloodGroups;
            }
            return Collections.emptyList();
        }

        @Override
        public boolean patientRegistration(PatientRegistrationDTO patientRegistrationDTO) {

            String registerId = crateRegisterId(patientRegistrationDTO);
            if (registerId!=null){
                patientRegistrationDTO.setRegisterId(registerId);
            }else
                log.info("register Id not created");

            DoctorRegisterEntity doctorRegisterEntity = doctorService.getDoctorById(patientRegistrationDTO.getDoctorId());

            DoctorTimeSlotEntity doctorTimeSlotEntity = adminService.getDoctorTimeSlotEntityById(patientRegistrationDTO.getSlotsTimingId());

            PatientRegisterEntity patientRegisterEntity = new PatientRegisterEntity();
            BeanUtils.copyProperties(patientRegistrationDTO,patientRegisterEntity);
            patientRegisterEntity.setRegisterId(registerId);
            patientRegisterEntity.setDoctor(doctorRegisterEntity);
            patientRegisterEntity.setSlotTiming(doctorTimeSlotEntity);
            patientRegisterEntity.setDoctorStatus(true);


            return patientRepository.registerPatient(patientRegisterEntity);
        }

        public String crateRegisterId(PatientRegistrationDTO patientRegistrationDTO){
            StringBuilder registerID = new StringBuilder("med");
            registerID.append(patientRegistrationDTO.getAge());

            for (int charIndex = 0 ; charIndex<=2 ; charIndex++){
                char character = patientRegistrationDTO.getName().charAt(charIndex);
                registerID.append(character);
            }

            for (int index=9 ; index>7 ;index--){
                char character = patientRegistrationDTO.getPhoneNumber().charAt(index);
                registerID.append(character);
            }
            return registerID.toString();
        }

    }
