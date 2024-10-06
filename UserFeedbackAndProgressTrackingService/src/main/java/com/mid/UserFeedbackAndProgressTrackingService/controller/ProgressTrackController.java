package com.mid.UserFeedbackAndProgressTrackingService.controller;

import com.mid.UserFeedbackAndProgressTrackingService.dto.HealthDataCurrentDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.InsightDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.TotalProgressDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.WeightProgressDto;
import com.mid.UserFeedbackAndProgressTrackingService.service.UserProgressInsightsService;
import com.mid.UserFeedbackAndProgressTrackingService.service.UserProgressTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/progress")
public class ProgressTrackController {

    @Autowired
    private UserProgressTrackService userProgressTrackService;
    @Autowired
    private UserProgressInsightsService userProgressInsightsService;
    @GetMapping("/insights")
    public InsightDto insightProgress(@RequestBody HealthDataCurrentDto healthDataCurrentDto) {
        return userProgressInsightsService.getHealthProgressByUser(healthDataCurrentDto);
    }

    @GetMapping("/track")
    public TotalProgressDto trackProgress(@RequestBody HealthDataCurrentDto healthDataCurrentDto) {
        return userProgressTrackService.getHealthProgressByUser(healthDataCurrentDto);
    }
}
