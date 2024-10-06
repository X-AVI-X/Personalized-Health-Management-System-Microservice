package com.midproject.recommendation.repository;

import com.midproject.recommendation.entity.SleepRecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepRecommendationRepository extends JpaRepository<SleepRecommendationEntity, Long> {
}
