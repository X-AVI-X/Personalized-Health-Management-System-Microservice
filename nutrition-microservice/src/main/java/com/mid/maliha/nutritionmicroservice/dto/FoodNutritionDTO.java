package com.mid.maliha.nutritionmicroservice.dto;

public class FoodNutritionDTO {
    private String food;
    private String nutritionalFact;
    private Integer caloriePerServing;
    private String serving;
    public FoodNutritionDTO() {
    }

    public FoodNutritionDTO(String food, String nutritionalFact, Integer caloriePerServing, String serving) {
        this.food = food;
        this.nutritionalFact = nutritionalFact;
        this.caloriePerServing = caloriePerServing;
        this.serving = serving;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getNutritionalFact() {
        return nutritionalFact;
    }

    public void setNutritionalFact(String nutritionalFact) {
        this.nutritionalFact = nutritionalFact;
    }

    public Integer getCaloriePerServing() {
        return caloriePerServing;
    }

    public void setCaloriePerServing(Integer caloriePerServing) {
        this.caloriePerServing = caloriePerServing;
    }

    public String getServing() {
        return serving;
    }

    public void setServing(String serving) {
        this.serving = serving;
    }
}
