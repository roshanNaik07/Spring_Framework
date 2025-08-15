package com.xworkz.dominos.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_info")
public class DominosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name = "price")
    private int price;

}
