package com.mid.UserFeedbackAndProgressTrackingService.dto.feedbackRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackRequestDto {
    private Long feedbackId;
    private String recommendationId;
    private String feedbackText;
    private String userId;
    private LocalDate date;
    private Integer rating;
}
