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
@NamedQuery(name = "findByName", query = "select a from AdharEntity a where a.name = : name")
@NamedQuery(name = "getByNameAndAge",query = "select entity from AdharEntity entity where entity.name =: name and entity.age = :age")
@NamedQuery(name = "getAgeAbove",query = "select entity from AdharEntity entity where entity.age >=: age ")
@NamedQuery(name = "getAgeAboveBetween",query = "select entity from AdharEntity entity where entity.age between  :age1 and :age2")
@NamedQuery(name="getNameByEmail",query = "select entity.name from AdharEntity entity Where entity.email =:emailBy ")
@NamedQuery(name="getPhoneNumberAndNameByEmail" ,query = "Select entity.ph,entity.name from  AdharEntity entity Where entity.email =:emailBy  ")
@NamedQuery(name = "getEntityByAgeAndPhoneNo",query = "select entity from AdharEntity entity where entity.age =: age and entity.ph =: PhoneNo")
@NamedQuery(name = "getListOfEntityByAge",query = "select entity from AdharEntity entity where entity.age =: age")
@NamedQuery(name = "getNameAndPhByAge",query = "select entity.name , entity.ph from AdharEntity entity where entity.age =: age ")
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
