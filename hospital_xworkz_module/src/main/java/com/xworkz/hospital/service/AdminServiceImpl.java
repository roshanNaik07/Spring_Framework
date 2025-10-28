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
            otpEmail(email, "Login OTP", "otp is : ", otp);
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
    public boolean registerDoctor(DoctorRegistrationDTO doctorRegistrationDTO , MultipartFile multipartFile) throws IOException {

        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get("D:\\Hospital\\" + doctorRegistrationDTO.getName() + System.currentTimeMillis() + ".jpg");
        Files.write(path, bytes);

        DoctorRegisterEntity doctorRegisterEntity = new DoctorRegisterEntity();
        BeanUtils.copyProperties(doctorRegistrationDTO, doctorRegisterEntity);

        DoctorImageInfoEntity image = new DoctorImageInfoEntity();
        image.setImageName(path.getFileName().toString());
        image.setOriginalImageName(multipartFile.getOriginalFilename());
        image.setImageSize(multipartFile.getSize());
        image.setImagePath(path.toString());

        image.setDoctor(doctorRegisterEntity);
        doctorRegisterEntity.setDoctorImageInfo(image);

        doctorRegistrationMail(doctorRegisterEntity.getEmail(), doctorRegisterEntity.getName());
        return adminRepository.registerDoctor(doctorRegisterEntity);
    }

    @Override
    public boolean saveSlotTime(SlotTimeDTO slotTimeDTO) {
        log.info("In service" + slotTimeDTO);
        SlotTimeEntity slotTimeEntity = new SlotTimeEntity();
        BeanUtils.copyProperties(slotTimeDTO, slotTimeEntity);
        return adminRepository.saveSlotTime(slotTimeEntity);
    }

    @Override
    public List<DoctorRegistrationDTO> getDoctorDtoBySpecialization(String specialization) {
        List<DoctorRegisterEntity> doctorRegisterEntities = adminRepository.getDoctorEntityBySpecialization(specialization);
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
        List<SlotTimeEntity> slotTimeEntities = adminRepository.getAllSlotsBySpecialization(specialization);

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
    public boolean addSpecialization(String specialization) {

        if (specialization == null || specialization.trim().isEmpty()) {
            log.info("Specialization is invalid");
            return false;
        }
        try {
            SpecializationEntity specializationEntity = new SpecializationEntity();
            specializationEntity.setSpecialization(specialization.trim());
            adminRepository.addSpecialization(specializationEntity);
            log.info("Specialization added successfully");
            return true;
        } catch (Exception e) {
            log.info("Error while adding specialization: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<String> getAllSpecializations() {
        return adminRepository.getAllSpecializations();
    }

    @Override
    public boolean saveDoctorSlots(String email, String slots) {
        return adminRepository.saveDoctorSlots(email,slots);
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


    private void otpEmail(String email, String sub, String body, String otp) {
        final String username = "roshannaik202055@gmail.com";
        final String password = "gnol ugqf btgk zmir";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("username"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(sub);
            message.setText(body + " " + otp);

            Transport.send(message);

            log.info("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Async
    private void doctorRegistrationMail(String email, String doctorName) {
        final String username = "roshannaik202055@gmail.com";
        final String password = "gnol ugqf btgk zmir";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("username"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Dear Dr. " + doctorName);
            message.setText("We are pleased to inform you that your details have been successfully registered on the MedCare Hospital Website.\n" +
                    "You are now part of our trusted network of specialists, and patients can connect with you for consultations.\n" +
                    "\n" +
                    "\n" +
                    "Thank you for joining MedCare!\n" +
                    "\n" +
                    "Best Regards,\n" +
                    "MedCare Team");

            Transport.send(message);

            log.info("Registration mail sent");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
