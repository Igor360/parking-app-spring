package com.parking.example.parking.http.controllers;

import com.parking.example.parking.http.requests.auth.LoginRequest;
import com.parking.example.parking.http.requests.auth.RegisterRequest;
import com.parking.example.parking.http.responses.auth.JwtResponse;
import com.parking.example.parking.http.responses.auth.RegisterResponse;
import com.parking.example.parking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        JwtResponse response = userService.auth(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse response = userService.register(request);
        return ResponseEntity.ok(response);
    }
}
