package com.mid.mentalhealthmicroservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category_based_exercise")
public class CategoryBasedExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String duration;
    private String recommendation;
    @ManyToMany
    private List<MentalExerciseEntity> mentalExerciseEntities;
    public CategoryBasedExerciseEntity() {
    }

    public CategoryBasedExerciseEntity(Integer id, String category, String duration, String recommendation, List<MentalExerciseEntity> mentalExerciseEntities) {
        this.id = id;
        this.category = category;
        this.duration = duration;
        this.recommendation = recommendation;
        this.mentalExerciseEntities = mentalExerciseEntities;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public List<MentalExerciseEntity> getMentalExerciseEntities() {
        return mentalExerciseEntities;
    }

    public void setMentalExerciseEntities(List<MentalExerciseEntity> mentalExerciseEntities) {
        this.mentalExerciseEntities = mentalExerciseEntities;
    }
}
