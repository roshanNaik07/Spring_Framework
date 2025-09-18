package com.xworkz.hospital.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "slots_info")
@Data
public class SlotTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "slot_start_time")
    private String slotStartTime;

    @Column(name = "slot_end_time")
    private String slotEndTime;
}
