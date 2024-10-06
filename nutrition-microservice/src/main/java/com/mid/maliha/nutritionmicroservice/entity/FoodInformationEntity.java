package com.mid.maliha.nutritionmicroservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "food_information")
public class FoodInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String food;
    private String recipe;
    private String nutritionalFact;
    private Integer caloriePerServing;
    private String serving;

    public FoodInformationEntity() {
    }

    public FoodInformationEntity(Integer id, String food, String recipe, String nutritionalFact, Integer caloriePerServing, String serving) {
        this.id = id;
        this.food = food;
        this.recipe = recipe;
        this.nutritionalFact = nutritionalFact;
        this.caloriePerServing = caloriePerServing;
        this.serving = serving;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
