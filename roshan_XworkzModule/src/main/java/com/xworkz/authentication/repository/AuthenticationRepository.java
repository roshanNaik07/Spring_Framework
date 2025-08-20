package com.xworkz.authentication.repository;

import com.xworkz.authentication.entity.AuthenticationEntity;

public interface AuthenticationRepository {

    boolean saveSignUpDetails(AuthenticationEntity authenticationEntity);

    AuthenticationEntity signIn(String username);
}
