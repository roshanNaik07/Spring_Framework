package com.xworkz.travel.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bgmi_info")
public class BgmiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "founder")
    private String founder;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "email")
    private String email;

    @Column(name = "gun_name")
    private String gunName;

    @Column(name = "age")
    private int age;
}
