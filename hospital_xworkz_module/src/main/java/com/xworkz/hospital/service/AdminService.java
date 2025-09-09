package com.xworkz.hospital.service;

public interface AdminService {

    boolean sendOTP(String email);

    boolean verifyOTP(String otp);

    boolean checkEmail(String email);
}
