package com.midproject.recommendation.controller;

//import com.midproject.recommendation.dto.DietRecommendDTO;
import com.midproject.recommendation.dto.ExerciseRecommendDTO;
import com.midproject.recommendation.dto.SleepRecommendationDTO;
//import com.midproject.recommendation.service.impl.DietRecommendationServiceImpl;
import com.midproject.recommendation.service.impl.ExerciseRecommendationServiceImpl;
import com.midproject.recommendation.service.impl.SleepRecommendationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/recommendations")
@AllArgsConstructor
public class RecommendationController {
    private final ExerciseRecommendationServiceImpl exerciseService;
    private final SleepRecommendationServiceImpl sleepRecommendService;
    //private final DietRecommendationServiceImpl dietRecommendationService;
    @GetMapping("/exercise")
    public ResponseEntity<ExerciseRecommendDTO> getExerciseRecommendation(){
        ExerciseRecommendDTO exerciseRecommendDTO = exerciseService.recommendExercise();
        return ResponseEntity.status(HttpStatus.OK).body(exerciseRecommendDTO);
    }
//    @GetMapping("/diet")
//    public ResponseEntity<DietRecommendDTO> getDietRecommendation(){
//        DietRecommendDTO dietRecommendDTO = dietRecommendationService.recommendDiet();
//        return ResponseEntity.status(HttpStatus.OK).body(dietRecommendDTO);
//    }
    @GetMapping("/sleep")
    public ResponseEntity<SleepRecommendationDTO> getSleepRecommendation(){
        SleepRecommendationDTO sleepRecommendationDTO = sleepRecommendService.recommendSleepTime();
        return ResponseEntity.status(HttpStatus.OK).body(sleepRecommendationDTO);
    }
}