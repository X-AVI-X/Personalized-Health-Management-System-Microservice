package com.mid.maliha.nutritionmicroservice.service;

import com.mid.maliha.nutritionmicroservice.dto.CategoryBasedNutritionDTO;
import com.mid.maliha.nutritionmicroservice.dto.FoodNutritionDTO;
import com.mid.maliha.nutritionmicroservice.dto.FoodRecipeDTO;
import com.mid.maliha.nutritionmicroservice.dto.MedicalConditionDTO;
import com.mid.maliha.nutritionmicroservice.entity.CategoryBasedNutritionEntity;
import com.mid.maliha.nutritionmicroservice.entity.FoodInformationEntity;
import com.mid.maliha.nutritionmicroservice.entity.UserInformationEntity;
import com.mid.maliha.nutritionmicroservice.exception.FoodNotFound;
import com.mid.maliha.nutritionmicroservice.repository.CategoryNutritionRepository;
import com.mid.maliha.nutritionmicroservice.repository.FoodInformationRepository;
import com.mid.maliha.nutritionmicroservice.repository.UserInformationRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NutritionService {
    @Autowired
    private FoodInformationRepository foodInformationRepository;

    @Autowired
    private CategoryNutritionRepository categoryNutritionRepository;

    @Autowired
    private UserInformationRepository userInformationRepository;

    public List<FoodRecipeDTO> getAllFoodRecipe(){
        List<FoodRecipeDTO> foodRecipeDTOList=new ArrayList<>();
        for(FoodInformationEntity foodInformationEntity:foodInformationRepository.findAll()){
            foodRecipeDTOList.add(new ModelMapper().map(foodInformationEntity,FoodRecipeDTO.class));
        }
        return foodRecipeDTOList.stream()
                .sorted(Comparator.comparing(FoodRecipeDTO::getFood))
                .collect(Collectors.toList());
    }

    public FoodRecipeDTO getFoodRecipe (String food) throws FoodNotFound {
        if(foodInformationRepository.existsByFood(food)){
            return new ModelMapper().map(foodInformationRepository.findByFood(food).orElseThrow(() -> new NullPointerException("No exercise")),FoodRecipeDTO.class);
        }
        throw new FoodNotFound();
    }
    public List<FoodNutritionDTO> getAllFoodNutrition(){
        List<FoodNutritionDTO> foodNutritionDTOList=new ArrayList<>();
        for(FoodInformationEntity foodInformationEntity:foodInformationRepository.findAll()){
            foodNutritionDTOList.add(new ModelMapper().map(foodInformationEntity, FoodNutritionDTO.class));
        }
        return foodNutritionDTOList.stream()
                .sorted(Comparator.comparing(FoodNutritionDTO::getFood))
                .collect(Collectors.toList());
    }
    public FoodNutritionDTO getFoodNutrition (String food) throws FoodNotFound {
        if(foodInformationRepository.existsByFood(food)){
            return new ModelMapper().map(foodInformationRepository.findByFood(food).orElseThrow(() -> new NullPointerException("No exercise")),FoodNutritionDTO.class);
        }
        throw new FoodNotFound();
    }
    public FoodNutritionDTO getFoodNutritionById (Integer foodId) throws FoodNotFound {
        if(foodInformationRepository.existsById(foodId)){
            return new ModelMapper().map(foodInformationRepository.findById(foodId).orElseThrow(() -> new NullPointerException("No exercise")),FoodNutritionDTO.class);
        }
        throw new FoodNotFound();
    }

    public Boolean setCategory(MedicalConditionDTO medicalConditionDTO){
        //get blood sugar level from the feign client and remove the below value
        UserInformationEntity userInformationEntity=new UserInformationEntity();
        Double blood_sugar=0.0;
        Integer highBloodPressure=0;
        if (medicalConditionDTO.getBpLow()<=85 && medicalConditionDTO.getBpLow()<=125){
            highBloodPressure=0;
        }
        else {
            highBloodPressure=1;
        }
        if(medicalConditionDTO.getAllergy()==0 && blood_sugar<=7 && highBloodPressure==0){
            userInformationEntity.setMedicalCategory("Normal");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==0 && blood_sugar<=7 && highBloodPressure==1){
            userInformationEntity.setMedicalCategory("HighBP");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==0 && blood_sugar>7 && highBloodPressure==0){
            userInformationEntity.setMedicalCategory("Diabetic");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==1 && blood_sugar<=7 && highBloodPressure==0){
            userInformationEntity.setMedicalCategory("Allergy");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==0 && blood_sugar>7 && highBloodPressure==1){
            userInformationEntity.setMedicalCategory("Diabetic & HighBP");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==1 && blood_sugar>7 && highBloodPressure==0){
            userInformationEntity.setMedicalCategory("Allergy & Diabetic");
            userInformationRepository.save(userInformationEntity);
        }

        else if(medicalConditionDTO.getAllergy()==1 && blood_sugar<=7 && highBloodPressure==1){
            userInformationEntity.setMedicalCategory("Allergy & HighBP");
            userInformationRepository.save(userInformationEntity);
        }

        else if(medicalConditionDTO.getAllergy()==1 && blood_sugar>7 && highBloodPressure==1){
            userInformationEntity.setMedicalCategory("Allergy, Diabetic & HighBP");
            userInformationRepository.save(userInformationEntity);
        }
        return true;
    }
    public CategoryBasedNutritionDTO categoryBasedMenu(Integer categoryId) throws FoodNotFound{
        CategoryBasedNutritionEntity categoryBasedNutritionEntity=categoryNutritionRepository.findById(categoryId).get();
        List<FoodNutritionDTO> foodNutritionDTOList=new ArrayList<>();
        for (FoodInformationEntity foodInformationEntity:categoryBasedNutritionEntity.getFoodNutritionEntityList())
            foodNutritionDTOList.add(new ModelMapper().map(foodInformationEntity,FoodNutritionDTO.class));
        CategoryBasedNutritionDTO categoryBasedNutritionDTO=new ModelMapper().map(categoryBasedNutritionEntity,CategoryBasedNutritionDTO.class);
        categoryBasedNutritionDTO.setMenuList(foodNutritionDTOList);
        return categoryBasedNutritionDTO;

    }
}
