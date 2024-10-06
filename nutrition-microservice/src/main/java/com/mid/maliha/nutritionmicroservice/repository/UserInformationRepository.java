package com.mid.maliha.nutritionmicroservice.repository;


import com.mid.maliha.nutritionmicroservice.entity.UserInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInformationRepository extends JpaRepository<UserInformationEntity,Integer> {
    Boolean existsByUserId(String userId);
    Optional<UserInformationEntity> findByUserId(String userId);

}
