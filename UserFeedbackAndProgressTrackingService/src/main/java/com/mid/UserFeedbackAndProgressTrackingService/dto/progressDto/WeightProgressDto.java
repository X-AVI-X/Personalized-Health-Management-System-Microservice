package com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightProgressDto {

    private Double previousWeight;
    private LocalDate previousDate;
    private Double currentWeight;
    private LocalDate presentDate;
    private String status;

}
