package com.moin.UserProfile.model;

import com.moin.UserProfile.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationResponse {
    private String token;
}
