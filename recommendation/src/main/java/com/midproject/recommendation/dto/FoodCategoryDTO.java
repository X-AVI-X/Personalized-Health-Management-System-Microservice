package com.midproject.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodCategoryDTO {
    private Integer id;
    private String category;
    private List<FoodNutritionDTO> menuList;
    private String recommendation;
}
