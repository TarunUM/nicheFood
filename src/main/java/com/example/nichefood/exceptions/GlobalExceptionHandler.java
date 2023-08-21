package com.example.nichefood.exceptions;

import com.example.nichefood.controllers.interfaces.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GeneralExceptions.class)
    public ResponseEntity<ErrorResponse<GeneralExceptions>> handleCustomException(GeneralExceptions e) {
        return new ResponseEntity<>(
                ErrorResponse.<GeneralExceptions>builder()
                        .error(e.getMessage())
                        .timestamp(e.getTimestamp())
                        .status(e.getStatusCode())
                        .build(),
                e.getStatusCode()
        );
    }
}
