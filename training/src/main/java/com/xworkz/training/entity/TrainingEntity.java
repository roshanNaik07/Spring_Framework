package com.xworkz.training.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "training_info")
public class TrainingEntity {

    @Id
    private int id;

    @Column(name = "training_name")
    private String trainingName;

    @Column(name = "location")
    private String location;

    @Column(name = "founder")
    private String founder;

    @Column(name = "since")
    private int since;

    @Column(name = "student_count")
    private int studentCount;

}
