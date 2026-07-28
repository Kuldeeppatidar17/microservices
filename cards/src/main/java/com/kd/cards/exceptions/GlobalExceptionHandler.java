package com.kd.cards.exceptions;

import com.kd.cards.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException ex){
        ErrorResponse errorResponse=new ErrorResponse(false, HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now(),null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateResourceException ex){
        ErrorResponse errorResponse=new ErrorResponse(false,HttpStatus.CONFLICT.value(), ex.getMessage(),LocalDateTime.now(),null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
