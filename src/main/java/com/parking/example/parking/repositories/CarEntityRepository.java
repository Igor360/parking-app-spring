package com.parking.example.parking.repositories;

import com.parking.example.parking.models.Car;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarEntityRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE c.user.id = :userId")
    List<Car> findByUserId(@Param("userId") Long userId);

    List<Car> findAll();
}
