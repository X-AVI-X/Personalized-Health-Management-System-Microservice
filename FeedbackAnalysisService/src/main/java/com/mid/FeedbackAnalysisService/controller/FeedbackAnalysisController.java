package com.mid.FeedbackAnalysisService.controller;

import com.mid.FeedbackAnalysisService.dto.FeedbackDto;
import com.mid.FeedbackAnalysisService.entity.FeedbackEntity;
import com.mid.FeedbackAnalysisService.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class FeedbackAnalysisController {

    @Autowired
    private FeedbackService feedbackService;
    @GetMapping("/feedback/{userId}")
    public List<FeedbackEntity> getUserFeedback(@PathVariable String userId) {
        return feedbackService.getUserFeedback(userId);
    }
}
