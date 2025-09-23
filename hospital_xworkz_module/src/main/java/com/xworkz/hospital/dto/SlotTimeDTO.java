package com.xworkz.hospital.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SlotTimeDTO {

    @NotNull(message = "Please select the slot start time ")
    private String slotStartTime;

    @NotNull(message = "Please select the slot end time")
    private String slotEndTime;

    @NotNull(message = "Please select the specialization")
    private String specialization;
}
