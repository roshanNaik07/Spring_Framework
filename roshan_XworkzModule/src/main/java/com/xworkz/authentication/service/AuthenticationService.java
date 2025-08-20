package com.xworkz.authentication.service;

import com.xworkz.authentication.dto.AuthenticationDto;

public interface AuthenticationService {

    boolean saveSignUpDetails(AuthenticationDto authenticationDto);

}
