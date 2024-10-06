package com.mid.UserFeedbackAndProgressTrackingService.networkmanager;

import com.mid.UserFeedbackAndProgressTrackingService.dto.HealthDataCurrentDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.SendHealthDataDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", configuration = FeignClientConfiguration.class)
public interface HealthDataFeignClient {

    @GetMapping("/users/health-data")
    SendHealthDataDto sendHealthData();

    @GetMapping("/users/getUserByEmail")
    UserDto getUserByEmail(@RequestParam("email") String email);

//    @PutMapping("/users/health-data-update")
//    void updateHealthDataDto(HealthDataCurrentDto healthDataCurrentDto);
}
