package com.moin.UserProfile.service;

import com.moin.UserProfile.dto.*;
import com.moin.UserProfile.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto user) throws Exception;
    UserDto getUser(String email);
    UserProfileDto createUserProfile(UserProfileDto userProfileDto);
    UserProfileDto getUserProfileDataById();

    UserProfileDto getUserProfileDataById(String id);

    UserProfileDto updateUserProfile(UserProfileDto userProfileDto);
    SendHealthDataDto sendHealthData();
    HealthDataDto createHealthData(HealthDataDto healthDataDto);
    UserEntity readByEmail(String email);
    HealthDataDto getUserHealthDataById();
    HealthDataDto updateUserHealthData(HealthDataDto healthDataDto);
    UserDto getUserByEmail(String userEmail);

}
