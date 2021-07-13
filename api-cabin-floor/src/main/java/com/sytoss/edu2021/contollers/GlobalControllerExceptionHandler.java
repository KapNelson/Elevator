package com.sytoss.edu2021.contollers;


import com.sytoss.edu2021.services.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleAlreadyExistsException(EntityNotFoundException exception, WebRequest request) {
        return ResponseEntity.status(418).body(exception.getMessage());
    }
}