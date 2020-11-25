package com.parking.example.parking.repositories;

import com.parking.example.parking.models.ParkingTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingTicketEntityRepository extends JpaRepository<ParkingTicket, Long> {
}
