package com.xworkz.vishalmart.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "vishalmart_info")
public class VishalMartEntity {

    @Id
    private int id;

    @Column(name = "location")
    private String location;

    @Column(name = "outlets")
    private int outletCount;

    @Column(name = "product")
    private String product;
}
