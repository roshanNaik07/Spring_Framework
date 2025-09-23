package com.xworkz.hospital.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "specializations")
@Data
@NamedQuery(name = "getAllSpecializations", query = "SELECT s.specialization FROM SpecializationEntity s")
public class SpecializationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "specialization", nullable = false, unique = true)
    private String specialization;

}