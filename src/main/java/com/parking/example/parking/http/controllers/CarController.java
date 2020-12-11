package com.parking.example.parking.http.controllers;

import com.parking.example.parking.http.requests.client.CreateCarRequest;
import com.parking.example.parking.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    CarService service;

    @GetMapping("/")
    public ResponseEntity<?> index() {
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void create(@Valid @RequestBody CreateCarRequest carRequest) {

    }

}
