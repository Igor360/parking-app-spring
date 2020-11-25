package com.parking.example.parking.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "parking_position")
public class ParkingPosition {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private UUID hash;

    @Getter
    @Setter
    private Long level;

    @Getter
    @Setter
    private Long positionNumber;

    @Getter
    @Setter
    private String description;
}
