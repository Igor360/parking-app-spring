package com.parking.example.parking.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "doc_number")
    private String docNumber;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Client() {
        super();
    }

    public Client(String firstName, String lastName, String docNumber, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.docNumber = docNumber;
        this.phone = phone;
    }

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.EAGER, targetEntity = ParkingTicket.class, mappedBy = "client")
    private List<ParkingTicket> tickets;
}
