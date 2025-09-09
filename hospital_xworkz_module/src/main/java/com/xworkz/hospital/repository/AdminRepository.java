package com.xworkz.hospital.repository;

public interface AdminRepository {

    String sendOTP(String email);

    boolean checkEmail(String email);

}
