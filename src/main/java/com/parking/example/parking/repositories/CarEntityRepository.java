package com.parking.example.parking.repositories;

import com.parking.example.parking.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEntityRepository extends JpaRepository<Car, Long> {
}
