package com.midproject.recommendation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SleepRecommendationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sleepRecommendID;
    private String userId;
    private String recommendationOfSleepHours;
}
