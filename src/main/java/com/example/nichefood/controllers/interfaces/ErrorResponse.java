package com.example.nichefood.controllers.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ErrorResponse<E> {
    private HttpStatus status;
    private Instant timestamp;
    private String error;
}
