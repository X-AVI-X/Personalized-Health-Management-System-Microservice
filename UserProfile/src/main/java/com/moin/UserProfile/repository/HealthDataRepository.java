package com.moin.UserProfile.repository;

import com.moin.UserProfile.entity.HealthDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthDataRepository extends JpaRepository<HealthDataEntity,String> {
    Optional<HealthDataEntity> findById(String id);
}
