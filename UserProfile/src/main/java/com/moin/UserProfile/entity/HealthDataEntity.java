package com.moin.UserProfile.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "health-data")
public class HealthDataEntity {

    @Id
    private String userId;
    private Double heightCm;
    private Double weightKg;
    private Double bloodSugarLevel;
    private Integer heartRate;
    private Double bmi;
    private LocalDate date;
    private Integer sleepHour;

}
