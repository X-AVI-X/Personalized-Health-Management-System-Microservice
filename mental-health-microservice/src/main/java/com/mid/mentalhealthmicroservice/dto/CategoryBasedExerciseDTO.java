package com.mid.mentalhealthmicroservice.dto;

import java.util.List;

public class CategoryBasedExerciseDTO {
    private String duration;
    private List<MentalExerciseDTO> exercises;
    public CategoryBasedExerciseDTO() {
    }

    public CategoryBasedExerciseDTO(String duration, List<MentalExerciseDTO> exercises) {
        this.duration = duration;
        this.exercises = exercises;
    }


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<MentalExerciseDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<MentalExerciseDTO> exercises) {
        this.exercises = exercises;
    }
}
