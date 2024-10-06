package com.mid.communityandsocialintegration.service.impl;

import com.mid.communityandsocialintegration.dto.UserDto;
import com.mid.communityandsocialintegration.feignclient.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserClient userClient;

    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return userClient.getUserByEmail(userEmail);
    }

    public UserDto getCurrentUserProfile(){
        return userClient.getCurrentUserProfile();
    }

    public UserDto getUserProfileById (String userId){
        return userClient.getUserProfileById(userId);
    }

}
