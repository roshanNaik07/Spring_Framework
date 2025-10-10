package com.xworkz.hospital.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "slots_info")
@Data
@NamedQuery(name = "getAllSlotsBySpecialization", query = "SELECT s FROM SlotTimeEntity s WHERE s.specialization = :specialization")
public class SlotTimeEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "slot_start_time")
    private String slotStartTime;

    @Column(name = "slot_end_time")
    private String slotEndTime;

    @Column(name = "specialization")
    private String specialization;
}
