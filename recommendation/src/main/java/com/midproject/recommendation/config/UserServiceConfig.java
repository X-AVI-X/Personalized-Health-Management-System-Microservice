package com.midproject.recommendation.config;

import com.midproject.recommendation.dto.HealthDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("user-service")
public interface UserServiceConfig {
    @GetMapping("/users/health-data")
    public HealthDataDTO sendHealthData();
}
