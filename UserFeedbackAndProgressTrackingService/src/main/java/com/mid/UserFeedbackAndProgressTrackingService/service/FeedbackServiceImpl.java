package com.mid.UserFeedbackAndProgressTrackingService.service;

import com.mid.UserFeedbackAndProgressTrackingService.dto.UserDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.feedbackRequestDto.FeedbackRequestDto;
import com.mid.UserFeedbackAndProgressTrackingService.entity.FeedbackEntity;
import com.mid.UserFeedbackAndProgressTrackingService.networkmanager.HealthDataFeignClient;
import com.mid.UserFeedbackAndProgressTrackingService.repository.FeedbackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private HealthDataFeignClient healthDataFeignClient;

    @Override
    public void submitFeedback(FeedbackRequestDto feedbackRequestDto) {
        feedbackRequestDto.setUserId(getCurrentUser().getId());
        feedbackRequestDto.setDate(LocalDate.now());
        FeedbackEntity feedbackEntity = new ModelMapper().map(feedbackRequestDto, FeedbackEntity.class);
        feedbackRepository.save(feedbackEntity);
    }

    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return healthDataFeignClient.getUserByEmail(userEmail);
    }
    @Override
    public List<FeedbackEntity> getUserFeedback(String userId) {
        return feedbackRepository.findByUserId(userId);
    }
}
