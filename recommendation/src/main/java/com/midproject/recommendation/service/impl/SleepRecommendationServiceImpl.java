package com.midproject.recommendation.service.impl;
import com.midproject.recommendation.dto.SleepRecommendationDTO;
import com.midproject.recommendation.entity.SleepRecommendationEntity;
import com.midproject.recommendation.networkmanager.UserServiceConfig;
import com.midproject.recommendation.repository.SleepRecommendationRepository;
import com.midproject.recommendation.service.SleepRecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class SleepRecommendationServiceImpl implements SleepRecommendService {
    private final UserServiceConfig userServiceConfig;
    private final SleepRecommendationRepository sleepRecommendationRepository;

    @Override
    public SleepRecommendationDTO recommendSleepTime() {
        var userHealthData = userServiceConfig.sendHealthData();
        SleepRecommendationEntity sleepRecommendationEntity = new SleepRecommendationEntity();
        sleepRecommendationEntity.setUserId(userHealthData.getUserId());
        if (isRecommendable(userHealthData.getAge())) {
            if (userHealthData.getAge() > 5 && userHealthData.getAge() <= 12) {
                sleepRecommendationEntity.setRecommendationOfSleepHours("9-12 hours of sleep needed");
            } else if (userHealthData.getAge() > 12 && userHealthData.getAge() <= 18) {
                sleepRecommendationEntity.setRecommendationOfSleepHours("8-10 hours of sleep needed");
            } else
                sleepRecommendationEntity.setRecommendationOfSleepHours("7-9 hours of sleep needed");
        }
        else throw new RuntimeException("User Data Not Found");
        sleepRecommendationRepository.save(sleepRecommendationEntity);
        return new SleepRecommendationDTO(
                sleepRecommendationEntity.getSleepRecommendID(),
                sleepRecommendationEntity.getRecommendationOfSleepHours());
    }
    private boolean isRecommendable(Integer age) {
        return age >= 5 && age<= 60;
    }
}

