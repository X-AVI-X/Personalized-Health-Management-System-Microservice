package com.mid.mentalhealthmicroservice.controller;

import com.mid.mentalhealthmicroservice.dto.MentalExerciseDTO;
import com.mid.mentalhealthmicroservice.dto.MoodDTO;
import com.mid.mentalhealthmicroservice.service.MentalHealthService;
import com.mid.mentalhealthmicroservice.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mood")
public class MoodController {
    @Autowired
    private MoodService moodService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertMood(@RequestBody MoodDTO moodDTO){
        return new ResponseEntity<>(moodService.insertMood(moodDTO), HttpStatus.CREATED);
    }

    @GetMapping("/track")
    public ResponseEntity<?> trackMood(){
        return new ResponseEntity<>(moodService.trackMood(), HttpStatus.CREATED);
    }

}
