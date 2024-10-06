package com.midproject.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseRecommendation {
    private String type;
    private String frequency;
    private String intensity;
    private String time;
    private String exerciseType;
}