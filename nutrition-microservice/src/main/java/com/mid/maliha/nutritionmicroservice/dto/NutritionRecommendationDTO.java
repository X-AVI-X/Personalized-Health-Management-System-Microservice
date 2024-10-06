package com.mid.maliha.nutritionmicroservice.dto;

public class NutritionRecommendationDTO {
    private String recommendation;
    public NutritionRecommendationDTO() {
    }
    public NutritionRecommendationDTO(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
