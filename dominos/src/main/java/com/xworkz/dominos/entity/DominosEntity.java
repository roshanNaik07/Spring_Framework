package com.xworkz.dominos.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "customer_info")
@NamedQuery(name = "getAllDetails",query = "select entity from DominosEntity entity")
@NamedQuery(name = "getEntityById",query = "select entity from DominosEntity entity where entity.id = :id")
@NamedQuery(name = "deleteById",query = "delete from DominosEntity entity where entity.id = :id")
@NamedQuery(name = "domainType",query = "select entity from DominosEntity entity where entity.email like concat('%', :domain)")

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
