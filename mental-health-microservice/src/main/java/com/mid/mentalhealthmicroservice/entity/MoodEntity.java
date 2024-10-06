package com.mid.mentalhealthmicroservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "mood_data")
public class MoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mood;
    private LocalDate presentDate;
    private String userId;
    public MoodEntity() {
    }

    public MoodEntity(Long id, String mood, LocalDate presentDate, String userId) {
        this.id = id;
        this.mood = mood;
        this.presentDate = presentDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public LocalDate getPresentDate() {
        return presentDate;
    }

    public void setPresentDate(LocalDate presentDate) {
        this.presentDate = presentDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
