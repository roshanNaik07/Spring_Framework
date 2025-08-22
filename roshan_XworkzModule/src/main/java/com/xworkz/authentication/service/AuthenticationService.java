package com.xworkz.authentication.service;

import com.xworkz.authentication.dto.AuthenticationDto;
import com.xworkz.authentication.dto.UpdateDto;

public interface AuthenticationService {

    boolean saveSignUpDetails(AuthenticationDto authenticationDto);

    AuthenticationDto signIn(String username , String password);

    boolean forgotPassword(String email , String password , String confirmPassword);

    UpdateDto updateUserData(UpdateDto updateDto);
}
