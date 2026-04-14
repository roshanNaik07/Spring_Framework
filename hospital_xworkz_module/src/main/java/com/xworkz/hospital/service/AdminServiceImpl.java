package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.dto.DoctorTimeSlotDTO;
import com.xworkz.hospital.dto.SlotTimeDTO;
import com.xworkz.hospital.entity.*;
import com.xworkz.hospital.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    EmailService emailService;

    private String otp;

    @Override
    public boolean sendOTP(String email) {

        log.info("In service email is: " + email);

        String adminEmail = adminRepository.sendOTP(email);
        if (adminEmail == null) {
            return false;
        } else if (adminEmail.equals(email)) {
            log.info("Email found");
            Random random = new Random();
            int number = 100000 + random.nextInt(900000);
            otp = String.valueOf(number);
            emailService.sendSimpleMessage(adminEmail,"Your OTP for Login is : "+otp+" .\n","Dear Admin your OTP will expire in 2 min \n Resend OTP Once expired..");
            log.info("The OTP is: " + otp);
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyOTP(String enteredOTP) {

        if (enteredOTP.equals(otp)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEmail(String email) {
        return adminRepository.checkEmail(email);
    }

    @Override
    public List<DoctorTimeSlotDTO> getDoctorTimeSlotDtoById(int id) {
        log.info("Running getDoctorTimeSlotDtoById in service"+id);
        List<DoctorTimeSlotEntity> doctorTimeSlotEntities = adminRepository.getDoctorTimeSlotEntitiesById(id);
        List<DoctorTimeSlotDTO> doctorTimeSlotDTOS = doctorTimeSlotEntities.stream().map(entity -> {
            DoctorTimeSlotDTO dto = new DoctorTimeSlotDTO();
            BeanUtils.copyProperties(entity,dto);
            return dto;
        }).collect(Collectors.toList());
        if(!doctorTimeSlotDTOS.isEmpty())
            return doctorTimeSlotDTOS;

        log.info("In service"+doctorTimeSlotDTOS);
        return Collections.emptyList();
    }

    @Override
    public DoctorTimeSlotEntity getDoctorTimeSlotEntityById(int id) {

        DoctorTimeSlotEntity doctorTimeSlotEntity = adminRepository.getDoctorTimeSlotEntityById(id);
        if (doctorTimeSlotEntity!=null){
            return doctorTimeSlotEntity;
        }

        return null;
    }

}
