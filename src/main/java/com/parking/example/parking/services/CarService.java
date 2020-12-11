package com.parking.example.parking.services;

import com.parking.example.parking.repositories.CarEntityRepository;
import com.parking.example.parking.services.base.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class CarService extends CRUDService<CarEntityRepository, Long> {
}
