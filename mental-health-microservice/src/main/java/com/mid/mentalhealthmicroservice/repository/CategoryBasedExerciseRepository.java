package com.mid.mentalhealthmicroservice.repository;

import com.mid.mentalhealthmicroservice.entity.CategoryBasedExerciseEntity;
import com.mid.mentalhealthmicroservice.entity.MentalExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryBasedExerciseRepository extends JpaRepository<CategoryBasedExerciseEntity,Integer> {
    Optional<CategoryBasedExerciseEntity> findByCategory(String category);
}
