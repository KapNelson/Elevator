package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.services.ErrorInAnotherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class GlobalControllerExceptionHandler{

    @ExceptionHandler(ErrorInAnotherService.class)
    public ResponseEntity<?> handleAlreadyExistsException(ErrorInAnotherService exception, WebRequest request) {
        return ResponseEntity.status(exception.getStatusCode()).body(exception.getMessage() + "\n" + exception.getExceptionClass());
    }
}
