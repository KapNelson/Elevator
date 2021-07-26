package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.exeption.AlreadyExistsException;
import com.sytoss.edu2021.exeption.EntityNotFoundException;
import com.sytoss.edu2021.exeption.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> handleAlreadyExistsException(AlreadyExistsException exception, WebRequest request) {
        return ResponseEntity.status(418).body(exception.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException exception, WebRequest request) {
        return ResponseEntity.status(418).body(exception.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleValidationException(EntityNotFoundException exception, WebRequest request) {
        return ResponseEntity.status(418).body(exception.getMessage());
    }
}