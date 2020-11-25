package com.parking.example.parking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestExceptions extends RuntimeException {
    public BadRequestExceptions(String message) {
        super(message);
    }
}
