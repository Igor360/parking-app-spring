package com.parking.example.parking.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
