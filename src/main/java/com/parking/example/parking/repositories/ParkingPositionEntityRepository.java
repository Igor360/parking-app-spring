package com.parking.example.parking.repositories;

import com.parking.example.parking.models.ParkingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPositionEntityRepository extends JpaRepository<ParkingPosition, Long> {
}