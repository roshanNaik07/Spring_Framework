package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorRegistrationDTO;
import com.xworkz.hospital.entity.DoctorImageInfoEntity;
import com.xworkz.hospital.entity.DoctorRegisterEntity;
import com.xworkz.hospital.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

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
        return doctorRepository.registerDoctor(doctorRegisterEntity);
    }

    @Override
    public List<DoctorRegistrationDTO> getAllDoctors() {
        List<DoctorRegisterEntity> doctorRegisterEntities = doctorRepository.getAllDoctors();
        if (doctorRegisterEntities != null && !doctorRegisterEntities.isEmpty()) {
            return doctorRegisterEntities.stream().map(entity -> {
                DoctorRegistrationDTO dto = new DoctorRegistrationDTO();
                BeanUtils.copyProperties(entity, dto);
                dto.setImageName(entity.getDoctorImageInfo().getImageName());
                return dto;
            }).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public boolean updateDoctorDetails(DoctorRegistrationDTO doctorRegistrationDTO, MultipartFile multipartFile) throws IOException {
        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get("D:\\Hospital\\" + doctorRegistrationDTO.getName() + System.currentTimeMillis() + ".jpg");
        Files.write(path, bytes);

        DoctorRegisterEntity doctorRegisterEntity = doctorRepository.getDoctorByEmail(doctorRegistrationDTO.getEmail());
        log.info("In service before update" + doctorRegisterEntity);
        doctorRegisterEntity.setName(doctorRegistrationDTO.getName());
        doctorRegisterEntity.setSpecialization(doctorRegistrationDTO.getSpecialization());
        doctorRegisterEntity.setQualification(doctorRegistrationDTO.getQualification());
        doctorRegisterEntity.setExperience(doctorRegistrationDTO.getExperience());
        doctorRegisterEntity.setPhoneNumber(doctorRegistrationDTO.getPhoneNumber());

        DoctorImageInfoEntity image = doctorRegisterEntity.getDoctorImageInfo();
        image.setImageName(path.getFileName().toString());
        image.setOriginalImageName(multipartFile.getOriginalFilename());
        image.setImageSize(multipartFile.getSize());
        image.setImagePath(path.toString());

        image.setDoctor(doctorRegisterEntity);
        doctorRegisterEntity.setDoctorImageInfo(image);

        log.info("In service after update" + doctorRegisterEntity);
        return doctorRepository.updateDoctorDetails(doctorRegisterEntity);
    }

    @Override
    public boolean deleteDoctorByEmail(String email) {
        return doctorRepository.deleteDoctorByEmail(email);
    }

    @Override
    public DoctorRegisterEntity getDoctorById(int id) {
        DoctorRegisterEntity entity = doctorRepository.getDoctorById(id);
        if (entity!=null){
            return entity;
        }else {
            log.info("could not found Doctor for this Id : " + id);
        }
        return null;
    }

    @Override
    public DoctorRegistrationDTO getDoctorByEmail(String email) {
        DoctorRegisterEntity entity = doctorRepository.getDoctorByEmail(email);
        if (entity != null) {
            DoctorRegistrationDTO dto = new DoctorRegistrationDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }
        return null;
    }

    private void doctorRegistrationMail(String email, String doctorName) {
        final String username = "roshannaik202055@gmail.com";
        final String password = "gnol ugqf btgk zmir";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

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
