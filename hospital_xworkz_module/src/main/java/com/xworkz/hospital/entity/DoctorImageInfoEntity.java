package com.xworkz.hospital.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "doctor")
@Entity
@Table(name = "doctor_image_info")
public class DoctorImageInfoEntity extends AuditEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private DoctorRegisterEntity doctor;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "original_image_name")
    private String originalImageName;

    @Column(name = "image_size")
    private long imageSize;

    @Column(name = "image_path")
    private String imagePath;
}
