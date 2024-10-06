package com.mid.communityandsocialintegration.service;

import com.mid.communityandsocialintegration.dto.PostDto;
import com.mid.communityandsocialintegration.entity.Post;
import com.mid.communityandsocialintegration.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    PostDto create(Post post) throws CustomException;

    void delete(Long postId) throws CustomException;

    PostDto getPost(Long id) throws CustomException;

    Post likePost(Long postId) throws CustomException;

    List<Post> newsFeedByFollowPreference();

//    Post likePost(Long postId, Long userId) throws CustomException;
}
