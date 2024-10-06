package com.mid.mentalhealthmicroservice.dto;

public class MentalHealthRecommendationDTO {
    private String recommendation;

    public MentalHealthRecommendationDTO() {
    }
    public MentalHealthRecommendationDTO(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
