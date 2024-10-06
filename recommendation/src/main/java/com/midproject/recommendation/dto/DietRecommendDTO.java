package com.midproject.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietRecommendDTO {
    private FoodNutritionDTO recommendDiet;
    private String recommendRestriction;
}
