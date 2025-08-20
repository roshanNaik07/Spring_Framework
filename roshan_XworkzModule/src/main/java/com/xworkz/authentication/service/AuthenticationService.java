package com.xworkz.authentication.service;

import com.xworkz.authentication.dto.AuthenticationDto;

public interface AuthenticationService {

    boolean saveSignUpDetails(AuthenticationDto authenticationDto);

    boolean signIn(String username , String password);

    boolean forgotPassword(String email , String password , String confirmPassword);
}
