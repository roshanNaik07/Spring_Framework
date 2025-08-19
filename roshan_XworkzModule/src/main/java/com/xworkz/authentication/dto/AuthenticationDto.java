package com.xworkz.authentication.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthenticationDto {


    @NotNull
    private String name;

    @NotNull
    private long phoneNo;

    @NotNull
    private String email;

    @NotNull
    private int age;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    private String address;

    @NotNull
    private String gender;

}
