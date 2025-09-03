package com.xworkz.dominos.service;

import com.xworkz.dominos.dto.DominosDto;
import com.xworkz.dominos.entity.DominosEntity;
import com.xworkz.dominos.repository.DominosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Service
public class DominosServiceImpl implements DominoService{

    @Autowired
    DominosRepository dominosRepository;

    @Override
    public boolean saveData(DominosDto dominosDto) {
        System.out.println("Running saveData in DominosServiceImpl ");
        DominosEntity entity = new DominosEntity();
        entity.setName(dominosDto.getName());
        entity.setEmail(dominosDto.getEmail());
        sendEmail(dominosDto.getEmail());

        entity.setPhoneNo(dominosDto.getPhoneNo());
        entity.setPrice(dominosDto.getPrice());
        return dominosRepository.saveData(entity);
    }

    private  void sendEmail(String email){


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
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Xworkz");
            message.setText("Hi Welcome to xworkz");

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DominosEntity> fetchDetails() {
        System.out.println("Running fetchDetails in DominosServiceImpl ");
        return dominosRepository.fetchDetails();
    }

    @Override
    public DominosDto getById(int id) {
        System.out.println("Running getById in DominosServiceImpl");

        DominosEntity entity = dominosRepository.getById(id);
        if(entity != null){
            DominosDto dto = new DominosDto();
            dto.setName(entity.getName());
            dto.setEmail(entity.getEmail());
            dto.setPhoneNo(entity.getPhoneNo());
            dto.setPrice(entity.getPrice());
            return dto;
        }
        return null;
    }

    @Override
    public boolean updateById(int id ,DominosDto dto) {
        System.out.println("Running updateId in DominosServiceImpl");
        DominosEntity dominosEntity = new DominosEntity();
        dominosEntity.setName(dto.getName());
        dominosEntity.setEmail(dto.getEmail());
        dominosEntity.setPhoneNo(dto.getPhoneNo());
        dominosEntity.setPrice(dto.getPrice());

        return dominosRepository.updateById(id,dominosEntity);
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("Running deleteById in DominosServiceImpl");
        return dominosRepository.deleteById(id);
    }

    @Override
    public List<DominosEntity> getDomainList(String domain) {

        return dominosRepository.getDomainList(domain);
    }

    @Override
    public List<String> getNameAbovePrice(int price) {

        return dominosRepository.getNamesAbovePrice(price);
    }

    @Override
    public long getEmailCount(String email) {

        long count = dominosRepository.getEmailCount(email);
        System.out.println(count);

        return count;
    }

}
