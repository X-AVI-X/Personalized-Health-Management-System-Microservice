package com.mid.FeedbackAnalysisService.networkmanager;

import com.mid.FeedbackAnalysisService.entity.FeedbackEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-feedback-progress", configuration = FeignClientConfiguration.class)
public interface HealthDataFeignClient {

    @GetMapping("/feedback/user/{userId}/feedbacks")
    List<FeedbackEntity> getUserFeedback(@PathVariable("userId") String userId);

//    @PutMapping("/users/health-data-update")
//    void updateHealthDataDto(HealthDataCurrentDto healthDataCurrentDto);
}
