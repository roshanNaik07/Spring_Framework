package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "admin_login")

@NamedQuery(name = "getAdminEmail",query = "select entity.email from AdminLoginEntity entity where entity.email =: email")

public class AdminLoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "email")
    String email;
}
