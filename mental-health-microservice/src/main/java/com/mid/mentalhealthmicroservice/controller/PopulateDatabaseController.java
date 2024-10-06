package com.mid.mentalhealthmicroservice.controller;


import com.mid.mentalhealthmicroservice.service.MentalHealthService;
import com.mid.mentalhealthmicroservice.service.PopulateDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/populate")
public class PopulateDatabaseController {
    @Autowired
    private PopulateDatabaseService populateDatabaseService;

    @GetMapping("/exercise")
    public ResponseEntity<?> populateExercise( ){
        if(populateDatabaseService.populateExercise()){
        return new ResponseEntity<>("Database populated", HttpStatus.ACCEPTED);}
        return new ResponseEntity<>("Cannot perform this action", HttpStatus.FORBIDDEN);
    }
    @GetMapping("/category")
    public ResponseEntity<?> populateCategory(){
        if(populateDatabaseService.populateCategory()){
            return new ResponseEntity<>("Database populated", HttpStatus.ACCEPTED);}
        return new ResponseEntity<>("Cannot perform this action",HttpStatus.FORBIDDEN);
    }

}
