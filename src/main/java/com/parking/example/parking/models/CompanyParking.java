package com.parking.example.parking.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company_parking")
public class CompanyParking {

    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    private String name;

    @Setter
    @Getter
    private String city;

    @Setter
    @Getter
    private String street;

    @Setter
    @Getter
    private String description;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_id")
    private Parking parking;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.EAGER, targetEntity = ParkingPosition.class, mappedBy = "parking")
    private List<ParkingPosition> positions;
}
