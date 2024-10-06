package com.mid.UserFeedbackAndProgressTrackingService.service;

import com.mid.UserFeedbackAndProgressTrackingService.dto.feedbackRequestDto.FeedbackRequestDto;
import com.mid.UserFeedbackAndProgressTrackingService.entity.FeedbackEntity;

import java.util.List;

public interface FeedbackService {

    void submitFeedback(FeedbackRequestDto feedbackRequestDto);

    List<FeedbackEntity> getUserFeedback(String userId);
}
