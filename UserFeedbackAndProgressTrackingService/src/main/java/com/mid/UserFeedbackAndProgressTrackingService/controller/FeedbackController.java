package com.mid.UserFeedbackAndProgressTrackingService.controller;

import com.mid.UserFeedbackAndProgressTrackingService.dto.feedbackRequestDto.FeedbackRequestDto;
import com.mid.UserFeedbackAndProgressTrackingService.entity.FeedbackEntity;
import com.mid.UserFeedbackAndProgressTrackingService.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedBackService;
    @PostMapping("/submit")
    public ResponseEntity<?> submitFeedback(@RequestBody FeedbackRequestDto feedbackRequestDto) {
        feedBackService.submitFeedback(feedbackRequestDto);
        return new ResponseEntity<>("Feedback submitted successfully", HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/feedbacks")
    public List<FeedbackEntity> getUserFeedback(@PathVariable String userId) {
        return feedBackService.getUserFeedback(userId);
    }
}
