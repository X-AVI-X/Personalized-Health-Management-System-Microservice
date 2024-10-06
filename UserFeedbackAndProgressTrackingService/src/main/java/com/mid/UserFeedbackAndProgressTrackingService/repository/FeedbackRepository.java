package com.mid.UserFeedbackAndProgressTrackingService.repository;

import com.mid.UserFeedbackAndProgressTrackingService.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {
    List<FeedbackEntity> findByUserId(String userId);
}
