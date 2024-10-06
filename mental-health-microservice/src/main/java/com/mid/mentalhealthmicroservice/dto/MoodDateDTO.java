package com.mid.mentalhealthmicroservice.dto;

import java.time.LocalDate;

public class MoodDateDTO {
    private String mood;
    private LocalDate date;

    public MoodDateDTO() {
    }

    public MoodDateDTO(String mood, LocalDate date) {
        this.mood = mood;
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
