package com.parking.example.parking.repositories;

import com.parking.example.parking.models.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingEntityRepository extends JpaRepository<Parking, Long> {
}
