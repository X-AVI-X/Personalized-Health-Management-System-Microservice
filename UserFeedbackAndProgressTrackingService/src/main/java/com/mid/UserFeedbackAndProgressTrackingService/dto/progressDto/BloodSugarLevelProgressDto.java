package com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodSugarLevelProgressDto {
    private Double previousBloodSugarLevel;
    private LocalDate previousDate;
    private Double currentBloodSugarLevel;
    private LocalDate presentDate;
    private String status;
}
