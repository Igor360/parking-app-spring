package com.parking.example.parking.http.responses.auth;

import lombok.Getter;
import lombok.Setter;

public class JwtResponse {

    @Getter @Setter
    private String token;

    @Getter @Setter
    private UserResponse data;

    public JwtResponse(String token, UserResponse data) {
        this.token = token;
        this.data = data;
    }
}
