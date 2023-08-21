package com.example.nichefood.controllers.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<E>{
    private HttpStatus status;
    private Instant timestamp;
    private String message;
    private int length;
    private E data;
}
