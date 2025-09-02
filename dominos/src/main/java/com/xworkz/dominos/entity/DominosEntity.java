package com.xworkz.dominos.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer_info")
@NamedQuery(name = "getAllDetails",query = "select entity from DominosEntity entity")
@NamedQuery(name = "getEntityById",query = "select entity from DominosEntity entity where entity.id = :id")
@NamedQuery(name = "deleteById",query = "delete from DominosEntity entity where entity.id = :id")
@NamedQuery(name = "domainType",query = "select entity from DominosEntity entity where entity.email like concat('%', :domain)")
@NamedQuery(name = "findNameAbovePrice", query = "select entity.name from DominosEntity entity where entity.price > :price")
@NamedQuery(name = "getEmailCount" , query = "select count(entity) from DominosEntity entity where entity.email =: email")

@Data
@AllArgsConstructor
@NoArgsConstructor
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
