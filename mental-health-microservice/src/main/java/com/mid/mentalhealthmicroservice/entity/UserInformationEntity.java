package com.mid.mentalhealthmicroservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_information")
public class UserInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    private String mentalHealthCategory;
    public UserInformationEntity() {
    }

    public UserInformationEntity(Integer id, String userId, String mood, String mentalHealthCategory, LocalDate currentDate) {
        this.id = id;
        this.userId = userId;
        this.mentalHealthCategory = mentalHealthCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMentalHealthCategory() {
        return mentalHealthCategory;
    }

    public void setMentalHealthCategory(String mentalHealthCategory) {
        this.mentalHealthCategory = mentalHealthCategory;
    }

}
