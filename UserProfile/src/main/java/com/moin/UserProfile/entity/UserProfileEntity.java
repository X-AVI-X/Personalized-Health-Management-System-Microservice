package com.moin.UserProfile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user-profile")
public class UserProfileEntity {
    @Id
    private String userId;
    private String name;
    private String gender;
    private Integer age;
    private String contactInfo;
    private String address;

}
