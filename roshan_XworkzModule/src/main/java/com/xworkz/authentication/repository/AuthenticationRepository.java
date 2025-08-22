package com.xworkz.authentication.repository;

import com.xworkz.authentication.entity.AuthenticationEntity;

public interface AuthenticationRepository {

    boolean saveSignUpDetails(AuthenticationEntity authenticationEntity);

    AuthenticationEntity signIn(String username);

    Boolean forgotPassword(String email ,String password,String confirmPassword);

    AuthenticationEntity updateUserData(AuthenticationEntity authenticationEntity);
}
