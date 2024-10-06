package com.midproject.recommendation.repository;

import com.midproject.recommendation.entity.DietRecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRecommendationRepository extends JpaRepository<DietRecommendationEntity, Long> {
}
