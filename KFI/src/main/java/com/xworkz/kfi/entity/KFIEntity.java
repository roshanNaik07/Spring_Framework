package com.xworkz.kfi.entity;

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
@Table(name = "kfi_info")
public class KFIEntity {

    @Id
    private int id;

    @Column(name = "actor_name")
    private String actorName;

    @Column(name = "actress_name")
    private String actress_name;

    @Column(name = "celeb_count")
    private int celebCount;

    @Column(name = "directors_count")
    private int directorsCount;

    @Column(name = "awards")
    private int awards;
}
