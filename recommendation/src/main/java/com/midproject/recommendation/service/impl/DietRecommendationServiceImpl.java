//package com.midproject.recommendation.service.impl;
//
//import com.midproject.recommendation.config.FoodCategoryServiceConfig;
//import com.midproject.recommendation.config.UserServiceConfig;
//import com.midproject.recommendation.dto.DietRecommendDTO;
//import com.midproject.recommendation.dto.FoodCategoryDTO;
//import com.midproject.recommendation.dto.FoodNutritionDTO;
//import com.midproject.recommendation.dto.HealthDataDTO;
//import com.midproject.recommendation.repository.DietRecommendationRepository;
//import com.midproject.recommendation.service.DietRecommendationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Random;
//
//@Service
//@RequiredArgsConstructor
//public class DietRecommendationServiceImpl implements DietRecommendationService {
//    private final DietRecommendationRepository dietRecommendationRepository;
//    private final UserServiceConfig userServiceConfig;
//    private final FoodCategoryServiceConfig foodCategoryServiceConfig;
//    private final ExerciseRecommendationServiceImpl exerciseRecommendationService;
//
//    @Override
//    public DietRecommendDTO recommendDiet() {
//        HealthDataDTO healthData = userServiceConfig.sendHealthData();
//        DietRecommendDTO recommended_Diet= new DietRecommendDTO();
//        if ((exerciseRecommendationService.checkBMI(healthData.getBmi()).equals("Normal"))
//                && (exerciseRecommendationService.checkBloodSugar(healthData.getBloodSugarLevel()).equals("Normal"))
//                && (exerciseRecommendationService.checkHeartRate(healthData.getHeartRate()).equals("Normal"))) {
//            FoodCategoryDTO foodCategory = foodCategoryServiceConfig.getFoodCategorybyCategory("Normal");
//            if (foodCategory != null) {
//                List<FoodNutritionDTO> menuList = foodCategory.getMenuList();
//                FoodNutritionDTO recommendedFood = menuList.get(pickRandomValue(menuList.size()));
//                recommended_Diet.setRecommendDiet(recommendedFood);
//                recommended_Diet.setRecommendRestriction(foodCategory.getRecommendation());
//            }
//        }
//        else if (exerciseRecommendationService.checkBloodSugar(healthData.getBloodSugarLevel()).equals("Diabetic")) {
//            FoodCategoryDTO foodCategory = foodCategoryServiceConfig.getFoodCategorybyCategory("Diabetic");
//            if (foodCategory != null) {
//                List<FoodNutritionDTO> menuList = foodCategory.getMenuList();
//                FoodNutritionDTO recommendedFood = menuList.get(pickRandomValue(menuList.size()));
//                recommended_Diet.setRecommendDiet(recommendedFood);
//                recommended_Diet.setRecommendRestriction(foodCategory.getRecommendation());
//            }
//        }
//        else if (exerciseRecommendationService.checkBloodSugar(healthData.getBloodSugarLevel()).equals("HìghBP")) {
//            FoodCategoryDTO foodCategory = foodCategoryServiceConfig.getFoodCategorybyCategory("HìghBP");
//            if (foodCategory != null) {
//                List<FoodNutritionDTO> menuList = foodCategory.getMenuList();
//                FoodNutritionDTO recommendedFood = menuList.get(pickRandomValue(menuList.size()));
//                recommended_Diet.setRecommendDiet(recommendedFood);
//                recommended_Diet.setRecommendRestriction(foodCategory.getRecommendation());
//            }
//        }
//        else throw new RuntimeException("Sorry, Unable to recommend Diet!");
//        return recommended_Diet;
//    }
//
//    public int pickRandomValue(int boundary) {
//        // Check if the boundary is non-negative
//        if (boundary < 0) {
//            throw new IllegalArgumentException("Boundary must be non-negative.");
//        }
//
//        // Generate a random value between 0 and the specified boundary (inclusive)
//        Random random = new Random();
//        return random.nextInt(boundary + 1);
//    }
//}
