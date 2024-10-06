package com.mid.UserFeedbackAndProgressTrackingService.service;

import com.mid.UserFeedbackAndProgressTrackingService.dto.HealthDataCurrentDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.TotalProgressDto;

public interface UserProgressTrackService {

    TotalProgressDto getHealthProgressByUser(HealthDataCurrentDto healthDataCurrentDto);
}
