package com.example.nichefood.exceptions;

import org.springframework.http.HttpStatus;

public class HotelExceptions extends RuntimeException{
    private HttpStatus statusCode;

    public HotelExceptions(String message) {
        super(message);
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public HotelExceptions(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public HotelExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.statusCode = httpStatus;
    }

}
