package com.parking.example.parking.models;

import com.parking.example.parking.models.enums.EPricingTypes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parking_pricing")
public class ParkingPricing {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EPricingTypes type;

    @Getter
    @Setter
    private Float price;
}
