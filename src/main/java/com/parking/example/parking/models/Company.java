package com.parking.example.parking.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "companies")
public class Company {

    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter
    @Setter
    private String description;

    @Setter
    @Getter
    @Column(name = "owner_name")
    private String ownerName;

    @Setter
    @Getter
    @Column(name = "owner_phone")
    private String ownerPhone;

    @Setter
    @Getter
    @Column(name = "owner_email")
    private String ownerEmail;

    @Setter
    @Getter
    private String address;

    @Setter
    @Getter
    @Column(name = "contact_phone")
    private String contactPhone;
}
