package com.mid.FeedbackAnalysisService.service;

import com.mid.FeedbackAnalysisService.entity.FeedbackEntity;

import java.util.List;

public interface FeedbackService {

    List<FeedbackEntity> getUserFeedback(String userId);
}
