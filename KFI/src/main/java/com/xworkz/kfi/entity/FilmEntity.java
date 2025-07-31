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
@Table(name = "film_info")
public class FilmEntity {

    @Id
    private int id;

    @Column(name = "film_name")
    private String filmName;

    @Column(name = "actor_name")
    private String actorName;

    @Column(name = "actress_name")
    private String actress_name;

    @Column(name = "directors_name")
    private String directorName;

    @Column(name = "awards")
    private int awards;

}
