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
@Table(name = "vendor")
public class GunVendor {

    @Id
    private int id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "since")
    private int since;

    @Column(name = "shop_area")
    private String area;

    @Column(name = "no_of_outlets")
    private int outlets;

    @Column(name = "owner")
    private String ownerName;

}
