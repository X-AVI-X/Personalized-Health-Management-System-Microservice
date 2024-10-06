package com.mid.UserFeedbackAndProgressTrackingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthDataCurrentDto {
    private Long healthDataId;
    private Double heightCm;
    private Double weightKg;
    private Double bloodSugarLevel;
    private Integer heartRate;
    private Double bmi;
    private LocalDate date;
    private Integer sleepHour;
    private Integer age;
}
