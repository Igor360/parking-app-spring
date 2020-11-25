package com.parking.example.parking.http.responses.auth;

import lombok.Getter;
import lombok.Setter;

public class RegisterResponse {

    @Getter
    @Setter
    private String message;

    public RegisterResponse(String message) {
        this.message = message;
    }
}
