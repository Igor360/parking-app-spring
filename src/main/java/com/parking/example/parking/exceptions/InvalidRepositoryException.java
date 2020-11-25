package com.parking.example.parking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Invalid repository")
public class InvalidRepositoryException extends RuntimeException {

}
