package com.midproject.recommendation.networkmanager;

import com.midproject.recommendation.dto.HealthDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "user-service", configuration = FeignClientConfiguration.class)
public interface UserServiceConfig {
    @GetMapping("/users/health-data")
    HealthDataDTO sendHealthData();

}

//@FeignClient("user-service")
//public interface UserServiceConfig {
//    @GetMapping("/users/health-data")
//    HealthDataDTO sendHealthData();
//}