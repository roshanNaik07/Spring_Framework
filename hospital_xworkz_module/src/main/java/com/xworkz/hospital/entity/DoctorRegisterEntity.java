package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "doctor_details")

@NamedQuery(name = "getAllDoctors", query = "select e from DoctorRegisterEntity e")
@NamedQuery(name = "getDoctorEntityByEmail", query = "select e from DoctorRegisterEntity e where e.email =: email")
@NamedQuery(name = "getDoctorEntitySpecialization",query = "select e from DoctorRegisterEntity e where e.specialization =: specialization and e.slotTimings is null")
@NamedQuery(name = "updateDoctorSlots", query = "update DoctorRegisterEntity e set e.slotTimings =: slotTimings where e.email =: email")
public class DoctorRegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "slot_timing")
    private String slotTimings;

}
