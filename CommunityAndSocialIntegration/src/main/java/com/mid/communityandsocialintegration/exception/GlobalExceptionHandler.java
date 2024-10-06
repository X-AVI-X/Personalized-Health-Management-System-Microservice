package com.mid.communityandsocialintegration.exception;

import com.mid.communityandsocialintegration.response.ActionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ActionResponse> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(ex.getErrorResponse(), HttpStatus.BAD_REQUEST);
    }
}