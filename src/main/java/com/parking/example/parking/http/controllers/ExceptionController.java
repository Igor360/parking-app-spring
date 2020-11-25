package com.parking.example.parking.http.controllers;

import com.parking.example.parking.exceptions.BadRequestExceptions;
import com.parking.example.parking.http.responses.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(BadRequestExceptions.class)
    public ResponseEntity<?> badRequestResponse(HttpServletRequest req, BadRequestExceptions ex) {
        logger.info("Bad request error : " + ex.getMessage());
        return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> userNotFoundResponse(HttpServletRequest req, UsernameNotFoundException ex) {
        logger.info("Not found error : " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

}

