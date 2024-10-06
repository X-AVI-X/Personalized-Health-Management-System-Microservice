package com.mid.FeedbackAnalysisService.entity;

import java.time.LocalDate;

public class FeedbackEntity {
    private Long feedbackId;
    private String recommendationId;
    private String userId;
    private String feedbackText;
    private LocalDate date;
    private Integer rating;
}
