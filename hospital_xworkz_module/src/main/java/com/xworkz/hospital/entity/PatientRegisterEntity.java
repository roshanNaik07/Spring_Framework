package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"doctor","slotTiming"})

@Entity
@Table(name = "patient_details")
public class PatientRegisterEntity extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false ,length = 30)
    private String name;

    @Column(name = "email" ,nullable = false ,unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false ,length = 10)
    private String phoneNumber;

    @Column(name = "age" ,nullable = false)
    private int age;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "bloodGroup", nullable = false)
    private String bloodGroup;

    @Column(name = "symptoms",nullable = false, length = 400)
    private String symptoms;

    private String registerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private DoctorRegisterEntity doctor;

    @Column(name = "doctor_Status")
    private boolean doctorStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_id", referencedColumnName = "id" ,nullable = false)
    private DoctorTimeSlotEntity slotTiming;

}
