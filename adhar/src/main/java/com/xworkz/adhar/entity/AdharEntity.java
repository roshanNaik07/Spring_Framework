package com.xworkz.adhar.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@NamedQuery(name = "findByName", query = "select entity from AdharEntity entity where entity.name = : name")
@NamedQuery(name = "getByNameAndAge",query = "select entity from AdharEntity entity where entity.name =: name and entity.age = :age")
@NamedQuery(name = "getAgeAbove",query = "select entity from AdharEntity entity where entity.age >=: age ")
@NamedQuery(name = "getAgeAboveBetween",query = "select entity from AdharEntity entity where entity.age between  :age1 and :age2")
@NamedQuery(name="getNameByEmail",query = "select entity.name from AdharEntity entity Where entity.email =:emailBy ")
@NamedQuery(name="getPhoneNumberAndNameByEmail" ,query = "Select entity.ph,entity.name from  AdharEntity entity Where entity.email =:emailBy  ")

@Table(name = "adhar_info")
public class AdharEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @NonNull
    @Column(name = "name")
    private String name ;

    @NonNull
    @Column(name = "age")
    private int age;

    @NonNull
    @Column(name = "phone_no")
    private long ph;

    @NonNull
    @Column(name = "email")
    private String email;

}
