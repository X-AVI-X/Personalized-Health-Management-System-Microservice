package com.moin.UserProfile.controller;

import com.moin.UserProfile.dto.*;
import com.moin.UserProfile.exceptions.AuthenticationExceptionFound;
import com.moin.UserProfile.service.serviceImplementation.UserServiceImplementation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserServiceImplementation userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDto userDto){
            UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registered Successfully");
        }

    @PostMapping("/createProfile")
    public ResponseEntity<UserProfileDto> createUserProfile(@RequestBody UserProfileDto userProfileDto){
            UserProfileDto userProfile = userService.createUserProfile(userProfileDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(userProfile);
    }
    @GetMapping("/getProfileById")
    public ResponseEntity<?> getUserProfileById(){
        try{
            UserProfileDto userProfile = userService.getUserProfileDataById();
            return ResponseEntity.status(HttpStatus.OK).body(userProfile);
        }
        catch (AuthenticationExceptionFound e)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/getUserProfile")
    public ResponseEntity<?> getById(@RequestParam("userId") String userId){
        try {
            UserProfileDto userProfile = userService.getUserProfileDataById(userId);
            return ResponseEntity.status(HttpStatus.OK).body(userProfile);
        }catch (AuthenticationExceptionFound e)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PutMapping("/updateUserProfile")
    public ResponseEntity<UserProfileDto> updateUserProfile(@RequestBody UserProfileDto userProfileDto){
        UserProfileDto userProfile = userService.updateUserProfile(userProfileDto);
        return ResponseEntity.status(HttpStatus.OK).body(userProfile);
    }

    @GetMapping("/health-data")
    public SendHealthDataDto sendHealthData(){
        return userService.sendHealthData();
    }

    @PostMapping("/createHealthDAta")
    public ResponseEntity<HealthDataDto> createHealthData(@RequestBody HealthDataDto healthDataDto){
        HealthDataDto healthData = userService.createHealthData(healthDataDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(healthData);
    }

    @GetMapping("/getHealthDataById")
    public ResponseEntity<HealthDataDto> getUserHealthDataById(){
        HealthDataDto healthData = userService.getUserHealthDataById();
        return ResponseEntity.status(HttpStatus.OK).body(healthData);
    }

    @PutMapping("/updateUserHealthData")
    public void updateUserHealthData(@RequestBody HealthDataDto healthDataDto){
        userService.updateUserHealthData(healthDataDto);
    }

    @GetMapping("/getUserByEmail")
    public UserDto getUserByEmail(@RequestParam("email") String email){
        return userService.getUserByEmail(email);
    }
}
