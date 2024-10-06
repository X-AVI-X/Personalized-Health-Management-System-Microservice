package com.mid.communityandsocialintegration.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String userID;
    private String name;
    private String email;
    private String gender;
    private Integer age;
    private String contactInfo;
    private String address;

//    private String id;
//    //@Email(message = "Invalid email")
//    private String email;
//    //@NotNull(message = "Password is required")
//    private String password;
//    // @NotNull(message = "Role is required")
//    private String role;
}
