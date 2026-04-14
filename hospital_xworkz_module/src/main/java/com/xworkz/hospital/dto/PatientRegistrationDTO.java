package com.xworkz.hospital.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PatientRegistrationDTO {

    @NotNull(message = "Patient name cannot be null")
    @Size(min = 3, max = 30, message = "Patient name must be between 3 and 30 characters")
    private String name;

    @NotNull(message = "Email cannot be empty")
    @Pattern(
            regexp = "^[A-Za-z0-9](\\.?[A-Za-z0-9_-])*@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})+$",
            message = "Enter a valid email"
    )
    private String email;

    @NotNull(message = "phoneNumber is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digit's")
    private String phoneNumber;

    @NotNull(message = "age cannot be empty")
    @Min(value = 1, message = "minimum age should be 1 year")
    @Max(value = 120, message = "Enter a valid age")
    private int age;

    @NotNull(message = "Address cannot be null")
    @Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters")
    private String address;

    @NotNull(message = "Blood group cannot be null")
    private String bloodGroup;

    @NotNull(message = "Symptoms cannot be null")
    @Size(min = 10, max = 400, message = "Symptoms description must be between 10 and 400 characters")
    private String symptoms;

    @NotNull(message = "Doctor specialization cannot be null")
    private String doctorSpcialization;

    @NotNull(message = "Doctor name cannot be null")
    private int doctorId;

    @NotNull(message = "Slots timing cannot be null")
    private int slotsTimingId;

    private String RegisterId;

}
