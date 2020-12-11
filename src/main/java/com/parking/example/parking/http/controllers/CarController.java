package com.parking.example.parking.http.controllers;

import com.parking.example.parking.helpers.Auth;
import com.parking.example.parking.http.requests.client.CreateCarRequest;
import com.parking.example.parking.http.responses.client.CarResponse;
import com.parking.example.parking.models.Car;
import com.parking.example.parking.models.enums.ECarType;
import com.parking.example.parking.services.CarService;
import com.parking.example.parking.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    CarService service;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(service.getUserCars(Auth.getAuthUser().getId()).stream().map(this::convertTo).collect(Collectors.toList()));
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void create(@Valid @RequestBody CreateCarRequest carRequest) {
        Car car = modelMapper.map(carRequest, Car.class);
        car.setUser(userService.findByEmail(Auth.getAuthUser().getEmail()));
        car.setType(ECarType.valueOf(carRequest.getType()));
        service.save(car);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable("id") Long id) {
        service.remove(id);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateClientProfile(@PathVariable("id") Long id, @Valid @RequestBody CreateCarRequest request) {
        Car car = service.get(id);
        modelMapper.map(request, car);
        service.save(car);
    }

    private CarResponse convertTo(Car car) {
        return modelMapper.map(car, CarResponse.class);
    }
}
