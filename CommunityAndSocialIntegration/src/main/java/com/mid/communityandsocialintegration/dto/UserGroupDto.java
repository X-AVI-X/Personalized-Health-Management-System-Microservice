package com.mid.communityandsocialintegration.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mid.communityandsocialintegration.entity.Post;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroupDto {
    private Long id;
    private String name;
    private List<Post> posts;
    private List<UserDto> joinedUsers;
}
