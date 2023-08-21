package com.example.nichefood.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class GeneralExceptions extends RuntimeException{
    private HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    private Instant timestamp = Instant.now();

    public GeneralExceptions(HttpStatus httpStatus ,String message) {
        super(message);
        this.statusCode = httpStatus;
    }

    public GeneralExceptions(String message) {
        super(message);
    }
}
