package com.parking.example.parking.services;

import com.parking.example.parking.models.Car;
import com.parking.example.parking.repositories.CarEntityRepository;
import com.parking.example.parking.services.base.CRUDService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends CRUDService<CarEntityRepository, Car> {

    public List<Car> getUserCars(Long userId) {
        return this.repository.findByUserId(userId);
    }
}
