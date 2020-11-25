package com.parking.example.parking.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "parking_tickets")
public class ParkingTicket {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private UUID hash;

    @Getter
    @Setter
    private Timestamp validFrom;

    @Getter
    @Setter
    private Timestamp validTo;

}
