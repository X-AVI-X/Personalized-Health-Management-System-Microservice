package com.mid.FeedbackAnalysisService.service;

import com.mid.FeedbackAnalysisService.entity.FeedbackEntity;
import com.mid.FeedbackAnalysisService.networkmanager.HealthDataFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private HealthDataFeignClient healthDataFeignClient;

    @Override
    public List<FeedbackEntity> getUserFeedback(String userId) {
        return healthDataFeignClient.getUserFeedback(userId);
    }
}
