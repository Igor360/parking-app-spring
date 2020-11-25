package com.parking.example.parking.repositories;

import com.parking.example.parking.models.ParkingPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPricingEntityRepository extends JpaRepository<ParkingPricing, Long> {
}
