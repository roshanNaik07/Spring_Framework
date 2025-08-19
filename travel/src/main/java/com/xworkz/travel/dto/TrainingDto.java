package com.xworkz.travel.dto;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TrainingDto {

    @NotNull
    @Size(min = 3,max = 10 ,message = "Training name should be 3-10 character")
    private String trainingName;

    @NotNull
    @Size(min=2 , max=30,message = "Location must be between 2-30 characters")
    private String location;

    @NotNull
    @Size(min=2 , max=20 ,message = "Course name should be between 2-20 characters")
    private String courseName;

    @NotNull
    @Pattern( regexp = "^[a-zA-Z0-9.%+-_]+@gmail\\.com" ,message = "mailID Should end with @gmail.com")
    private String email;

    @NotNull
    @Size(min=2,max=10,message = "Trainer name should be between 5-10 characters")
    private String trainerName;

    @NotNull
    @Min(value = 5 , message = "experience should be above 5")
    @Max(value = 30, message = "experience should be below 30")
    private int trainerExperience;

    @NotNull
    @Min( value = 1000000000L,message = "Phone number should contain 10 digits")
    @Max( value = 9999999999L,message = "Phone number should not exceed 10 digits")
    private long phoneNo;

}
