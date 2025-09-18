package com.xworkz.hospital.dto;


import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode

public class DoctorRegistrationDTO {

    @NotNull(message = "Name can not be empty")
    @Size(min = 3, max = 30, message = "name should be between 3 to 30 characters")
    private String name;

    @NotNull(message = "email cannot be empty")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Enter a valid email ending with @gmail.com.")
    private String email;

    @NotNull(message = "Please select specialization")
    private String specialization;

    @NotNull(message = "Qualification cannot be empty")
    @Pattern(
            regexp = "^[A-Za-z.,()\\s]{2,50}$",
            message = "Enter a valid qualification (2 to 50 characters, letters, spaces, ., , , ( ) allowed)."
    )
    private String qualification;

    @NotNull(message = "Experience cannot be empty")
    @Min(value = 1, message = "minimum experience should be 1 year")
    @Max(value = 40, message = "experience above 40 years not allowed")
    private Integer experience;

    @NotNull(message = "phoneNumber is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digit's")
    private String phoneNumber;

    private String imageName;

}
