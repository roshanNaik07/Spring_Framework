package com.xworkz.hospital.service;

import com.xworkz.hospital.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    private String otp;

    @Override
    public boolean sendOTP(String email) {

        System.out.println("Running sendOTP in adminServiceImpl");

        String adminEmail = adminRepository.sendOTP(email);
        if (adminEmail==null){
            return false;
        }
        else if (adminEmail.equals(email)) {
            System.out.println("Email found");
            Random random = new Random();
            int number = 100000 + random.nextInt(900000);
            otp = String.valueOf(number);
            email(email,"Login OTP","otp is : ",otp);
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyOTP(String enteredOTP) {

        if (enteredOTP.equals(otp)){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEmail(String email) {
        return adminRepository.checkEmail(email);
    }

    private void email(String email, String sub, String body, String otp) {
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
            message.setText(body+" "+otp);

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
