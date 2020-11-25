package com.parking.example.parking.repositories;

import com.parking.example.parking.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsEntityRepository extends JpaRepository<Cars, Long> {
}
