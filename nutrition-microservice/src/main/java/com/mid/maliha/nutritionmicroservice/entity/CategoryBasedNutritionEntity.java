package com.mid.maliha.nutritionmicroservice.entity;

import com.mid.maliha.nutritionmicroservice.dto.FoodNutritionDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "food_nutrition_category")
public class CategoryBasedNutritionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String recommendation;
    @ManyToMany
    private List<FoodInformationEntity> foodInformationEntityList;

    public CategoryBasedNutritionEntity() {
    }

    public CategoryBasedNutritionEntity(Integer id, String category, String recommendation, List<FoodInformationEntity> foodNutritionDTOList) {
        this.id = id;
        this.category = category;
        this.recommendation = recommendation;
        this.foodInformationEntityList = foodNutritionDTOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public List<FoodInformationEntity> getFoodNutritionEntityList() {
        return foodInformationEntityList;
    }

    public void setFoodNutritionEntityList(List<FoodInformationEntity> foodNutritionDTOList) {
        this.foodInformationEntityList = foodNutritionDTOList;
    }
}
