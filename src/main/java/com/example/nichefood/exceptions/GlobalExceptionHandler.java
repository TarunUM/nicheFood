package com.example.nichefood.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FoodExceptions.class)
    public ResponseEntity<Object> handleException(FoodExceptions e) {
        return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
    }

    @ExceptionHandler(HotelExceptions.class)
    public ResponseEntity<Object> handleException(HotelExceptions e) {
        return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
    }
}
