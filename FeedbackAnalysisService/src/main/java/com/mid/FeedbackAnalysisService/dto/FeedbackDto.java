package com.mid.FeedbackAnalysisService.dto;

import java.time.LocalDate;

public class FeedbackDto {
    private Long feedbackId;
    private String recommendationId;
    private String userId;
    private String feedbackText;
    private LocalDate date;
    private Integer rating;
}
