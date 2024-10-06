package com.mid.UserFeedbackAndProgressTrackingService.service;

import com.mid.UserFeedbackAndProgressTrackingService.dto.HealthDataCurrentDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.SendHealthDataDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.*;
import com.mid.UserFeedbackAndProgressTrackingService.networkmanager.HealthDataFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserProgressTrackServiceImpl implements UserProgressTrackService {

    @Autowired
    private HealthDataFeignClient healthDataFeignClient;

    @Override
    public TotalProgressDto getHealthProgressByUser(HealthDataCurrentDto healthDataCurrentDto) {

        SendHealthDataDto healthDataDto = healthDataFeignClient.sendHealthData();
        if (healthDataDto == null) {
            return null;
        }
        //Current Values
        Double height = healthDataCurrentDto.getHeightCm();
        Double weight = healthDataCurrentDto.getWeightKg();
        Integer age = healthDataCurrentDto.getAge();
        Integer heartRate = healthDataCurrentDto.getHeartRate();
        Double bloodSugarLevel = healthDataCurrentDto.getBloodSugarLevel();

        //Initialize Dto
        WeightProgressDto weightProgressDto = new WeightProgressDto();
        BloodSugarLevelProgressDto bloodSugarLevelProgressDto = new BloodSugarLevelProgressDto();
        BmiProgressDto bmiProgressDto = new BmiProgressDto();
        HeartRateProgressDto heartRateProgressDto = new HeartRateProgressDto();

        //Set Current Progress
        Double currentBmi = calculateBmi(height, weight);
        weightProgressDto.setCurrentWeight(weight);
        weightProgressDto.setPresentDate(LocalDate.now());
        bloodSugarLevelProgressDto.setCurrentBloodSugarLevel(bloodSugarLevel);
        bloodSugarLevelProgressDto.setPresentDate(LocalDate.now());
        bmiProgressDto.setCurrentBmi(currentBmi);
        bmiProgressDto.setPresentDate(LocalDate.now());
        heartRateProgressDto.setCurrentHeartRate(heartRate);
        heartRateProgressDto.setPresentDate(LocalDate.now());


        //Set Previous Progress
        Double previousBmi = calculateBmi(healthDataDto.getHeightCm(),healthDataDto.getWeightKg());
        weightProgressDto.setPreviousWeight(healthDataDto.getWeightKg());
        weightProgressDto.setPreviousDate(healthDataDto.getDate());
        bloodSugarLevelProgressDto.setPreviousBloodSugarLevel(healthDataDto.getBloodSugarLevel());
        bloodSugarLevelProgressDto.setPreviousDate(healthDataDto.getDate());
        bmiProgressDto.setPreviousBmi(previousBmi);
        bmiProgressDto.setPreviousDate(healthDataDto.getDate());
        heartRateProgressDto.setPreviousHeartRate(healthDataDto.getHeartRate());
        heartRateProgressDto.setPreviousDate(healthDataDto.getDate());

        //Set Status
        String weightMessage = calculateWeightProgress(weight, healthDataDto);
        String bmiMessage = calculateBmiProgress(height, weight, healthDataDto);
        String heartRateMessage = calculateHeartRateProgress(age, heartRate, healthDataDto);
        String bloodSugarLevelMessage = calculateBloodSugarLevel(bloodSugarLevel, healthDataDto);

        //Set Status Into Dto
        weightProgressDto.setStatus(weightMessage);
        bmiProgressDto.setStatus(bmiMessage);
        heartRateProgressDto.setStatus(heartRateMessage);
        bloodSugarLevelProgressDto.setStatus(bloodSugarLevelMessage);

        //healthDataFeignClient.updateHealthDataDto(healthDataCurrentDto);

        //Set Total Progress
        TotalProgressDto totalProgressDto = new TotalProgressDto();
        totalProgressDto.setHeartRateProgressDto(heartRateProgressDto);
        totalProgressDto.setBmiProgressDto(bmiProgressDto);
        totalProgressDto.setWeightProgressDto(weightProgressDto);
        totalProgressDto.setBloodSugarLevelProgressDto(bloodSugarLevelProgressDto);
        return totalProgressDto;
    }

    public String calculateWeightProgress(Double weight, SendHealthDataDto healthDataDto){
        double initialWeight = healthDataDto.getWeightKg();
        double weightChange = weight - initialWeight;

        String message = "";

        if (weightChange > 0) {
            message += "Your weight increased by " + weightChange + " kilograms.";
        } else if (weightChange < 0) {
            message += "Your weight decreased by " + (-weightChange) + " kilograms.";
        } else {
            message += "Your weight has not changed.";
        }
        return message;
    }

    public String calculateBmiProgress(Double height, Double weight, SendHealthDataDto healthDataDto){

        double initialBmi = calculateBmi(healthDataDto.getHeightCm(), healthDataDto.getWeightKg());;
        double currentBmi = calculateBmi(height, weight);
        double bmiChange = currentBmi - initialBmi;

        String message = "";

        if (bmiChange > 0) {
            message += "Your bmi increased by " + bmiChange;
        } else if (bmiChange < 0) {
            message += "Your bmi decreased by " + (-bmiChange);
        } else {
            message += "Your bmi has not changed.";
        }
        message+= checkBmiImprovement(currentBmi, initialBmi);

        return message;
    }

    private double calculateBmi(double heightCm, double weightKg) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    private String checkBmiImprovement(Double currentBmi, Double initialBmi){

        if(Math.abs(22-currentBmi) < Math.abs(22-initialBmi)){
            return "Congratulations! Your BMI has improved by " + Math.abs(currentBmi-initialBmi);
        }
        else if(Math.abs(22-currentBmi) > Math.abs(22-initialBmi))
        {
            return "Your BMI got worse by " + Math.abs(currentBmi - initialBmi);
        }
        else {
            return "Your BMI has not been improved.";
        }
    }

    private String calculateBloodSugarLevel(Double bloodSugarLevel, SendHealthDataDto healthDataDto){

        Double initialBloodSugarLevel = healthDataDto.getBloodSugarLevel();
        if (bloodSugarLevel < 5.6) {
            return "Your current blood sugar level is " + bloodSugarLevel + ". You do not have diabetes.";
        } else if (bloodSugarLevel >= 5.6 && bloodSugarLevel <= 6.9) {
            if (initialBloodSugarLevel < 5.6) {
                return "Your current blood sugar level is " + bloodSugarLevel + ". You have moved from not having diabetes to prediabetes.";
            } else if (initialBloodSugarLevel >= 5.6 && initialBloodSugarLevel <= 6.9) {
                return "Your current blood sugar level is " + bloodSugarLevel + ". You still have prediabetes.";
            } else {
                return "Your current blood sugar level is " + bloodSugarLevel + ". You have prediabetes.";
            }
        } else {
            if (initialBloodSugarLevel < 5.6) {
                return "Your current blood sugar level is " + bloodSugarLevel + ". You have diabetes.";
            } else if (initialBloodSugarLevel >= 5.6 && initialBloodSugarLevel <= 6.9) {
                return "Your current blood sugar level is " + bloodSugarLevel + ". You have moved from prediabetes to diabetes.";
            } else {
                return "Your current blood sugar level is " + bloodSugarLevel + ". You still have diabetes.";
            }
        }
    }

    public String calculateHeartRateProgress(Integer userAge, Integer heartRate, SendHealthDataDto healthDataDto){
        double initialHeartRate = healthDataDto.getHeartRate();
        double heartRateChange = heartRate - initialHeartRate;
        String message="";

        if(heartRateChange > 0)
        {
            message+="Your heart rate has increased by "+ heartRateChange + ".";
        }
        int lowerRange;
        int upperRange;

        if (userAge <= 1) {
            lowerRange = 80;
            upperRange = 190;
        } else if (userAge == 2) {
            lowerRange = 80;
            upperRange = 130;
        } else if (userAge == 3 || userAge == 4) {
            lowerRange = 80;
            upperRange = 120;
        } else if (userAge == 5 || userAge == 6) {
            lowerRange = 75;
            upperRange = 115;
        } else if (userAge >= 7 && userAge <= 9) {
            lowerRange = 70;
            upperRange = 110;
        } else {
            lowerRange = 60;
            upperRange = 100;
        }
        if (heartRate < lowerRange) {
            return message+="Your heart rate is below the recommended range for your age. Consult a healthcare professional.";
        } else if (heartRate > upperRange) {
            return message+="Your heart rate is above the recommended range for your age. Consult a healthcare professional.";
        }
        return message+="Your heart rate is within the recommended range for your age. Keep up the good work!";
    }
}
