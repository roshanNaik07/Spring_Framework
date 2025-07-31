package com.xworkz.entity;

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
@Table(name = "gun_info")
public class GunEntity {
    @Id
    private int id;

    @Column(name = "gun_name")
    private String gunName;

    @Column(name = "gun_price")
    private int price;

    @Column(name = "gun_color")
    private String color;

    @Column(name = "gun_weight")
    private int weight;

    @Column(name = "owner")
    private String ownerName;
}
