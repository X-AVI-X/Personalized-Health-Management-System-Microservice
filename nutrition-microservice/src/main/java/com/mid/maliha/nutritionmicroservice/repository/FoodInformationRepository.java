package com.mid.maliha.nutritionmicroservice.repository;

import com.mid.maliha.nutritionmicroservice.entity.FoodInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodInformationRepository extends JpaRepository<FoodInformationEntity,Integer> {
    Optional<FoodInformationEntity> findByFood(String food);
    Boolean existsByFood(String food);
}
