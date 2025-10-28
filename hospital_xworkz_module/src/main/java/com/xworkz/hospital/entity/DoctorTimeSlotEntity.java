package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"doctor", "patients"})

@Entity
@Table(name = "doctors_slot_info")
@NamedQuery(name = "getDoctorSlotEntitiesById" ,query = "select e from DoctorTimeSlotEntity e where e.doctor.id =: id")
@NamedQuery(name = "getEntityBYId",query = "select e from DoctorTimeSlotEntity e where e.id =: id")
public class DoctorTimeSlotEntity extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "slot_timings", nullable = false)
    private String slotTimings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private DoctorRegisterEntity doctor;

    @OneToMany(mappedBy = "slotTiming", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<PatientRegisterEntity> patients = new ArrayList<>();

}
