package com.midproject.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodNutritionDTO {
    private String food;
    private String nutritionalFact;
    private Integer caloriePerServing;
    private String serving;
}
