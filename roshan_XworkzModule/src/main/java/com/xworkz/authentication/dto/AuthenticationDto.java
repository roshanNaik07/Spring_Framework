package com.xworkz.authentication.dto;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AuthenticationDto {

    @NotNull(message = "name cannot be empty")
    @Size(min = 3 ,max = 20 ,message = "name should contain between 3 - 20 characters")
    private String name;

    @NotNull(message = "Phone number cannot be null")
    @Min(value = 1000000000L , message = "phone number should be 10 digits")
    @Max(value = 9999999999L , message = "phone number should be 10 digits")
    private Long phoneNo;

    @NotNull(message = "Email cannot be empty")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$" , message = "Email should end with @gmail.com")
    private String email;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must not exceed 100")
    private Integer age;

    @NotNull(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{5,}$" , message = "Password must be at least 5 characters and contain both letters and numbers")

    private String password;

    @NotNull(message = "Confirm Password cannot be empty")
    private String confirmPassword;

    @NotNull(message = "Address cannot be empty")
    @Size(min = 4 ,max = 50 ,message = "Address should contain between 4 - 50 characters")
    private String address;

    @NotNull(message = "Please select a gender")
    private String gender;

}
