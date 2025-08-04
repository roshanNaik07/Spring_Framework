package com.xworkz.dmart.entity;


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
@Table(name = "dmart_info")
public class DmartEntity {

    @Id
    private int id ;

    @Column(name = "location")
    private String location;

    @Column(name = "product")
    private String product;

    @Column(name = "type")
    private String type;

}
