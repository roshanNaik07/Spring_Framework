package com.xworkz.authentication.repository;

import com.xworkz.authentication.entity.AuthenticationEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository{

    @Override
    public boolean saveSignUpDetails(AuthenticationEntity authenticationEntity) {



        return false;
    }

}
