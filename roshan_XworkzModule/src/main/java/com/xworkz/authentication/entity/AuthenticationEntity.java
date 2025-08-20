package com.xworkz.authentication.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "authentication_details")

@NamedQuery(name = "getByUsernameAndPassword", query = "select entity from AuthenticationEntity entity where entity.name =:username")
@NamedQuery(name = "getEntityByEmail" ,query = "select entity from AuthenticationEntity entity where entity.email =: email")
public class AuthenticationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNo")
    private Long phoneNo;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

}
