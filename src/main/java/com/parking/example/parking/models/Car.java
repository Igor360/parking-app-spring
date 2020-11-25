package com.parking.example.parking.models;

import com.parking.example.parking.models.enums.ECarType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cars")
public class Car {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Size(max = 60)
    private String name;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ECarType type;

    @Getter
    @Setter
    @Size(max = 17)
    @Column(name = "vin_code")
    private String vinCode;
}
