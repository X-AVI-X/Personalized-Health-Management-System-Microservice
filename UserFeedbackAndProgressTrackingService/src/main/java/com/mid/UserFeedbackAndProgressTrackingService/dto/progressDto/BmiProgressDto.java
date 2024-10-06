package com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BmiProgressDto {
    private Double previousBmi;
    private LocalDate previousDate;
    private Double currentBmi;
    private LocalDate presentDate;
    private String status;
}
