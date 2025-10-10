package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "doctor_details")

@NamedQuery(name = "getAllDoctors", query = "select e from DoctorRegisterEntity e")
@NamedQuery(name = "getDoctorEntityByEmail", query = "select e from DoctorRegisterEntity e where e.email =: email")
@NamedQuery(name = "getDoctorEntitySpecialization",query = "select e from DoctorRegisterEntity e where e.specialization =: specialization")
public class DoctorRegisterEntity extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DoctorImageInfoEntity doctorImageInfo;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DoctorTimeSlotEntity> slots = new ArrayList<>();

}
