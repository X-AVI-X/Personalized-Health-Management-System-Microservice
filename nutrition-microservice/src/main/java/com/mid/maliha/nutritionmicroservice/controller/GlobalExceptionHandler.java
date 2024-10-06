package com.mid.maliha.nutritionmicroservice.controller;

import com.mid.maliha.nutritionmicroservice.exception.FoodNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({FoodNotFound.class})
    public ResponseEntity<?> handleFoodNotFound(){
        return new ResponseEntity<>(new FoodNotFound().getMessage(), HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<?> handleRuntimeException(){
//        return new ResponseEntity<>(new CustomException("No exercise exists in this name").getMessage(), HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler({UserNotFound.class})
//    public ResponseEntity<?> handleUserNotFound(){
//        return new ResponseEntity<>(new UserNotFound().getMessage(), HttpStatus.BAD_REQUEST);
//    }

}
