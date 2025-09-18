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

}
