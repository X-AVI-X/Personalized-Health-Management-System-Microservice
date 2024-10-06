package com.mid.UserFeedbackAndProgressTrackingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsightDto {
    private String weightProgress;
    private String bmiProgress;
    private String heartRateProgress;
    private String bloodSugarLevel;
}
