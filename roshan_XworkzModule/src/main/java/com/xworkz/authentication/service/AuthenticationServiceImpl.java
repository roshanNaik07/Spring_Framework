package com.xworkz.authentication.service;

import com.xworkz.authentication.dto.AuthenticationDto;
import com.xworkz.authentication.entity.AuthenticationEntity;
import com.xworkz.authentication.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    AuthenticationRepository authenticationRepository;

    @Override
    public boolean saveSignUpDetails(AuthenticationDto authenticationDto) {

        AuthenticationEntity authenticationEntity = new AuthenticationEntity();
        authenticationEntity.setName(authenticationDto.getName());
        authenticationEntity.setPhoneNo(authenticationDto.getPhoneNo());
        authenticationEntity.setEmail(authenticationDto.getEmail());
        authenticationEntity.setAge(authenticationDto.getAge());
        authenticationEntity.setPassword(authenticationDto.getPassword());
        authenticationEntity.setConfirmPassword(authenticationDto.getConfirmPassword());
        authenticationEntity.setAddress(authenticationDto.getAddress());
        authenticationEntity.setGender(authenticationDto.getGender());

        return authenticationRepository.saveSignUpDetails(authenticationEntity);
    }


}
