package com.midproject.recommendation.repository;

import com.midproject.recommendation.entity.ExerciseRecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExerciseRecommendationRepository extends JpaRepository<ExerciseRecommendationEntity, Long> {
}
