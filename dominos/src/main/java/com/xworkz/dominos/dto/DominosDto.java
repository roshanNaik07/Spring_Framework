package com.xworkz.dominos.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class DominosDto {

    @NonNull
    @Size(min = 3, max = 20, message = "Name should be between 3-20 characters")
    private String name;

    @NonNull
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",message = "Email should end with @gmail.com")
    private String email;

    @NonNull
    @Pattern(regexp = "\\d{10}",message = "phone number should be 10 digits")
    private long phoneNo;

    @NonNull
    @Min(value = 100, message = "min price is 100")
    @Max(value = 300, message = "Max value is 300")
    private int price;

}
