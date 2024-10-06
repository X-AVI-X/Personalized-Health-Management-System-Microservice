package com.midproject.recommendation.service.impl;
import com.midproject.recommendation.dto.ExerciseRecommendDTO;
import com.midproject.recommendation.entity.ExerciseRecommendationEntity;
import com.midproject.recommendation.networkmanager.UserServiceConfig;
import com.midproject.recommendation.repository.ExerciseRecommendationRepository;
import com.midproject.recommendation.service.ExerciseRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ExerciseRecommendationServiceImpl implements ExerciseRecommendationService {
    private final UserServiceConfig userServiceConfig;
    private final ExerciseRecommendationRepository exerciseRepository;

    @Override
    public ExerciseRecommendDTO recommendExercise() {
        var userHealthData = userServiceConfig.sendHealthData();

        ExerciseRecommendationEntity exerciseRecommendationEntity = new ExerciseRecommendationEntity();
        exerciseRecommendationEntity.setUserId(userHealthData.getUserId());
        List<String> report  = new ArrayList<>();
        if (isRecommendable(userHealthData.getAge())) {
            report.add("BMI Report:" + checkBMI(userHealthData.getBmi()));
            report.add("BloodSugar Report:" + checkBloodSugar(userHealthData.getBloodSugarLevel()));
            report.add("HeartRate Report:" + checkHeartRate(userHealthData.getHeartRate()));
            exerciseRecommendationEntity.setReports(report);
            exerciseRecommendationEntity.setRecommendation(recommendation_of_Exercise(userHealthData.getBmi(), userHealthData.getAge()));
            exerciseRepository.save(exerciseRecommendationEntity);
        }
        else throw new RuntimeException("User Data Not Found");
        return new ExerciseRecommendDTO(exerciseRecommendationEntity.getReports(), exerciseRecommendationEntity.getRecommendation());
    }

    public boolean isRecommendable(Integer age) {
        return age >= 18 && age <= 60;
    }

    public String checkBMI(double userBMI) {
        if (userBMI < 18.5)
            return "UnderWeight";
        else if (userBMI < 30 && userBMI > 25)
            return "OverWeight";
        else if (userBMI > 34) {
            return "You are Obese";
        } else return "Normal";
    }

    public String checkBloodSugar(double userBloodSugar) {
        //low:<=55 normal:56-69 high:>=70
        if (userBloodSugar < 56) {
            return "Low Blood Sugar";
        } else if (userBloodSugar >= 69) {
            return "Normal";
        } else {
            return "Diabetic";
        }
    }

    public String checkHeartRate(Integer heartRate) {
        //<80 low pressure, 80-120 normal, >120 high
        if (heartRate < 80) return "Blood Pressure is low";
        else if (heartRate > 120) return "HighBP";
        else return "Ñormal";
    }

    public String recommendation_of_Exercise(double bmi, Integer age) {
        String exerciseRecommendation = "";
        if (bmi < 18.5 || age < 35) {
            exerciseRecommendation=("""
                    Type: Muscular Strength
                    Frequency:Exercises 2-4 times per week
                    Intensity:Add or maintain weight and repetitions
                    Time:About 30-60 minutes
                    Type:Resistance training yoga, Pilates, light weights. Anaerobic
                    """);
        } else if (bmi < 30 && bmi > 25) {
            if (age > 35) {
                exerciseRecommendation = ("""
                        Type: Muscular Strength
                        Frequency:Exercises 2-3 times per week
                        Intensity:Add or maintain weight and repetitions
                        Time:About 30-50 minutes
                        Type:Resistance training yoga, Pilates, light weights. Anaerobic
                        """);
            }
            exerciseRecommendation = ("""
                    Type: Muscular Endurance
                    Frequency:Weight train 2-4 times per week
                    Intensity:60-75% of max 3 sets of 8-12 repetitions
                    Time:About 30-60 minutes
                    Type:activities such as weight lifting and sit ups
                    """);
        } else if (bmi > 34) {
            if (age > 45) {
                exerciseRecommendation = ("""
                        Type: Muscular Strength
                        Frequency:Exercises 2-5 times per week
                        Intensity:Add or maintain weight and repetitions
                        Time:About 30-70 minutes
                        Type:Resistance training yoga,walk, Pilates, light weights. Anaerobic
                        """);
            }
            exerciseRecommendation = ("""
                    Type: Muscular Endurance
                    Frequency:Exercise 3-5 times per week
                    Intensity:Train at 60-80% of target heart rate
                    Time:About 20-60 minutes per session
                    Type:Any aerobic activity keeping the heart rate within the target zone.
                    """);
        }
        return exerciseRecommendation;
    }
}
    