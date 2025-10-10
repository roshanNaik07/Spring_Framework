package com.xworkz.hospital.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "blood_group")
@Data
@NamedQuery(name = "getAllBloodGroups", query = "SELECT b.bloodGroup FROM BloodGroupEntity b")
public class BloodGroupEntity extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "blood_group", nullable = false, unique = true)
    String bloodGroup;
}
