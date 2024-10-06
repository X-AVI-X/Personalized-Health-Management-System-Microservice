package com.midproject.recommendation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExerciseRecommendationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long exerciseId;
    private String userId;
    private List<String> reports;
    private String recommendation;

//    public void setReports(String givenReport) {
//        this.reports.add(givenReport);
//    }
}
