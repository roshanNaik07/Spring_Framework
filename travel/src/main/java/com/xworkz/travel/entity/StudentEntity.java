package com.xworkz.travel.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student_info")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "firstName")
    String firstName;

    @Column(name = "middleName")
    String middleName;

    @Column(name = "lastName")
    String lastName;

    @Column(name = "email")
    String email;

    @Column(name = "usn")
    String usn;

    @Column(name = "age")
    int age;

    @Column(name = "phoneNo")
    String phoneNo;

}
