package com.moin.UserProfile.repository;

import com.moin.UserProfile.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity,String> {
    Optional<UserProfileEntity> findByUserId(String userId);
}
