package com.mid.maliha.nutritionmicroservice.exception;

public class FoodNotFound extends Exception {
    private static final String MESSAGE = "No food exists in this name";

    public FoodNotFound() {
        super(MESSAGE);
    }

    public FoodNotFound(String message) {
        super(message);
    }
}