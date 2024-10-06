package com.mid.mentalhealthmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    //@Email(message = "Invalid email")
    private String email;
    //@NotNull(message = "Password is required")
    private String password;
    // @NotNull(message = "Role is required")
    private String role;
}