package com.moin.UserProfile.repository;

import com.moin.UserProfile.entity.MentalHealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentalHealthRepository extends JpaRepository<MentalHealthEntity,String> {
}
