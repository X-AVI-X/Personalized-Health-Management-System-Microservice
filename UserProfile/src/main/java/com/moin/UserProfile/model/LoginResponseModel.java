package com.moin.UserProfile.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseModel {
    private String username;
    private String bearerToken;
}
