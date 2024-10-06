package com.mid.maliha.nutritionmicroservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_information")
public class UserInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    private String medicalCategory;
    public UserInformationEntity() {
    }

    public UserInformationEntity(Integer id, String userId, String mood, String medicalCategory, LocalDate currentDate) {
        this.id = id;
        this.userId = userId;
        this.medicalCategory = medicalCategory;
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
    public String getMedicalCategory() {
        return medicalCategory;
    }

    public void setMedicalCategory(String medicalCategory) {
        this.medicalCategory = medicalCategory;
    }

}
