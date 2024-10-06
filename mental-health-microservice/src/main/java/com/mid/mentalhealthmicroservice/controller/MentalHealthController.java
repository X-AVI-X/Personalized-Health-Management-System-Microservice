package com.mid.mentalhealthmicroservice.controller;

import com.mid.mentalhealthmicroservice.dto.MentalExerciseDTO;
import com.mid.mentalhealthmicroservice.dto.QuestionsDTO;
import com.mid.mentalhealthmicroservice.exception.ExerciseNotFound;
import com.mid.mentalhealthmicroservice.exception.UserNotFound;
import com.mid.mentalhealthmicroservice.service.MentalHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mental-health")
public class MentalHealthController {
    @Autowired
    private MentalHealthService mentalHealthService;

    @PostMapping("exercise/create")
    public ResponseEntity<?> createExercise(@RequestBody MentalExerciseDTO mentalExerciseDTO){
        return new ResponseEntity<>(mentalHealthService.createMentalExercise(mentalExerciseDTO),HttpStatus.CREATED);
    }

    @GetMapping("/exercises/all")
    public ResponseEntity<?> allExercise(){
        return new ResponseEntity<>(mentalHealthService.getAllMentalExercise(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/search/{exercise}")
    public ResponseEntity<?> searchExercise(@PathVariable String exercise ) throws ExerciseNotFound {
        return new ResponseEntity<>(mentalHealthService.getMentalExercise(exercise),HttpStatus.ACCEPTED);
    }

    @PostMapping("survey")
    public ResponseEntity<?> questions(@RequestBody QuestionsDTO questionsDTO){
        if (mentalHealthService.findMentalHealth(questionsDTO)){
            return new ResponseEntity<>("Thank you",HttpStatus.ACCEPTED );
        }
        return new ResponseEntity<>("You already took the survey!",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/exercises/user-specific")
    public ResponseEntity<?> userBasedExercise() throws UserNotFound{
        return new ResponseEntity<>(mentalHealthService.getUserBasedMentalExercise(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<?> userBasedRecommendation() throws UserNotFound {
        return new ResponseEntity<>(mentalHealthService.getUserBasedRecommendation(),HttpStatus.ACCEPTED);
    }

}
