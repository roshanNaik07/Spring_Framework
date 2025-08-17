    package com.xworkz.dominos.dto;

    import lombok.*;

    import javax.validation.constraints.*;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode

    public class DominosDto {

        @NotNull
        @Size(min = 3, max = 20, message = "Name should be between 3-20 characters")
        private String name;

        @NotNull
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",message = "Email should end with @gmail.com")
        private String email;

        @NotNull
        @Pattern(regexp = "\\d{10}",message = "phone number should be 10 digits")
        private String phoneNo;

        @NotNull
        @Min(value = 100, message = "min price is 100")
        @Max(value = 300, message = "Max price is 300")
        private int price;

    }
