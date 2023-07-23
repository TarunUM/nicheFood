package com.example.nichefood.exceptions;

import org.springframework.http.HttpStatus;

public class FoodExceptions extends RuntimeException{
    private HttpStatus statusCode;

    public FoodExceptions(String message) {
        super(message);
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public FoodExceptions(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public FoodExceptions(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
