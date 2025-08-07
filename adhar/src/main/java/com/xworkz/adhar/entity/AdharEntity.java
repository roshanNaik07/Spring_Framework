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
