package com.parking.example.parking.models;

import com.parking.example.parking.models.enums.EPricingTypes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parking_pricing")
@NoArgsConstructor
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

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private ParkingPosition position;
}
