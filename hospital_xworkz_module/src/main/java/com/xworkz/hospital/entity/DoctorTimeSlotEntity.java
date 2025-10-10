package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "doctor")

@Entity
@Table(name = "doctors_slot_info")
@NamedQuery(name = "getDoctorSlotEntitiesById" ,query = "select e from DoctorTimeSlotEntity e where e.doctor.id =: id")
public class DoctorTimeSlotEntity extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "slot_timings", nullable = false)
    private String slotTimings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private DoctorRegisterEntity doctor;

}
