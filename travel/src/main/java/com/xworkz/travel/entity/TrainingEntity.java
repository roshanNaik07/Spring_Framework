package com.xworkz.travel.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "training_info")
public class TrainingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "training_name")
    private String trainingName;

    @Column(name = "location")
    private String location;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "email")
    private String email;

    @Column(name = "trainer_name")
    private String trainerName;

    @Column(name = "trainer_experience")
    private int trainerExperience;

    @Column(name = "phoneNo")
    private long phoneNo;

}
