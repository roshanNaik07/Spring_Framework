package com.xworkz.authentication.service;

import com.xworkz.authentication.dto.AuthenticationDto;
import com.xworkz.authentication.entity.AuthenticationEntity;
import com.xworkz.authentication.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    AuthenticationRepository authenticationRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean saveSignUpDetails(AuthenticationDto authenticationDto) {

        AuthenticationEntity authenticationEntity = new AuthenticationEntity();
        authenticationEntity.setName(authenticationDto.getName());
        authenticationEntity.setPhoneNo(authenticationDto.getPhoneNo());
        authenticationEntity.setEmail(authenticationDto.getEmail());
        sendEmail(authenticationEntity.getEmail());
        authenticationEntity.setAge(authenticationDto.getAge());
        authenticationEntity.setPassword(bCryptPasswordEncoder.encode(authenticationDto.getPassword()));
        authenticationEntity.setConfirmPassword(authenticationDto.getConfirmPassword());
        authenticationEntity.setAddress(authenticationDto.getAddress());
        authenticationEntity.setGender(authenticationDto.getGender());

        return authenticationRepository.saveSignUpDetails(authenticationEntity);

    }

    @Override
    public boolean signIn(String username, String password) {

        AuthenticationEntity authenticationEntity = authenticationRepository.signIn(username);
        if (authenticationEntity == null){
            return false;
        }

        if (username.equals(authenticationEntity.getName()) && bCryptPasswordEncoder.matches(password,authenticationEntity.getPassword())) {
            System.out.println("Username and Password Matched");
            return true;
        }
        return false;
    }

    private void sendEmail(String email) {
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
            message.setSubject("Successfully Registered");
            message.setText("Dear,"
                    + "\n\n Thank u for visiting my site");

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
