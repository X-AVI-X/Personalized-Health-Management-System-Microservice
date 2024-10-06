package com.mid.communityandsocialintegration.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mid.communityandsocialintegration.entity.Comment;
import com.mid.communityandsocialintegration.entity.User;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {
    private Long id;
    private UserDto user;
    private String postText;
    private List<UserDto> likedUsers;
    private Long likes= 0L;
    private List<Comment> comments;
    private LocalDateTime localDateTime;
    private boolean isGroupPost;
}
