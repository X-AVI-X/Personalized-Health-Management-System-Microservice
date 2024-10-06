package com.mid.maliha.nutritionmicroservice.dto;

import java.util.List;

public class CategoryBasedNutritionDTO {
    private Integer id;
    private String category;
    private List<FoodNutritionDTO> menuList;

    public CategoryBasedNutritionDTO() {
    }

    public CategoryBasedNutritionDTO(Integer id, String category, List<FoodNutritionDTO> menuList) {
        this.id = id;
        this.category = category;
        this.menuList = menuList;
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

    public List<FoodNutritionDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<FoodNutritionDTO> menuList) {
        this.menuList = menuList;
    }
}
