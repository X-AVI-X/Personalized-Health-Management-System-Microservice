package com.mid.maliha.nutritionmicroservice.dto;

public class FoodRecipeDTO {
    private String food;
    private String recipe;

    public FoodRecipeDTO() {
    }
    public FoodRecipeDTO(String food, String recipe) {
        this.food = food;
        this.recipe = recipe;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
