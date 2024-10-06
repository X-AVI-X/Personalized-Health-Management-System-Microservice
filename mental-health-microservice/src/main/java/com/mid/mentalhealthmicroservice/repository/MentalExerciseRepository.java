package com.mid.mentalhealthmicroservice.repository;

import com.mid.mentalhealthmicroservice.entity.MentalExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentalExerciseRepository extends JpaRepository<MentalExerciseEntity,Integer> {
    Optional<MentalExerciseEntity> findByExercise(String exercise);
    Boolean existsByExercise(String exercise);
}