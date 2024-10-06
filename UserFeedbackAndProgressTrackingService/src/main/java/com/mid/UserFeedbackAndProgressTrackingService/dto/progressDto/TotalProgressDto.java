package com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalProgressDto {
    private BloodSugarLevelProgressDto bloodSugarLevelProgressDto;
    private BmiProgressDto bmiProgressDto;
    private HeartRateProgressDto heartRateProgressDto;
    private WeightProgressDto weightProgressDto;
}
