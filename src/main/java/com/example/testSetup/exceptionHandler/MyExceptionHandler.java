package com.example.testSetup.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse>  handleIllegalArgumentException(IllegalArgumentException illegalArgumentException){
        return ResponseEntity.badRequest().body(ErrorResponse.builder().errorMessage(illegalArgumentException.getMessage()).statusCode(400).build());

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericExceptionhandler(Exception e){
        return ResponseEntity.badRequest().body(ErrorResponse.builder().errorMessage(e.getMessage()).statusCode(400).build());
    }
}
