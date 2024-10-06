package com.mid.mentalhealthmicroservice.dto;

import java.time.LocalDate;

public class MoodDTO {
    private String mood;

    public MoodDTO() {
    }

    public MoodDTO(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
