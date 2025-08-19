package com.xworkz.travel.dto;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {

    @NotNull
    @Size(min = 3,max = 10 ,message = "first name should be 3-10 character")
    private String firstName;

    @NotNull
    @Size(min=0 , max=10,message = "middle name cannot exceed 10 characters")
    private String middleName;

    @NotNull
    @Size(min=2 , max=10 ,message = "last name should be between 2-10 characters")
    private String lastName;

    @NotNull
    @Pattern( regexp = "^[a-zA-Z0-9.%+-_]+@gmail\\.com" ,message = "mailID Should end with @gmail.com")
    private String email;

    @NotNull
    @Size(min=5,max=10,message = "Usn should be between 5-10 characters")
    private String usn;

    @NotNull
    @Min(value = 18 , message = "age should be above 18")
    @Max(value = 40, message = "Age should be below 40")
    private int age;

    @Pattern(regexp = "\\d{10}",message = "Phone No should be 10 digits")
    private String phoneNo;

}
