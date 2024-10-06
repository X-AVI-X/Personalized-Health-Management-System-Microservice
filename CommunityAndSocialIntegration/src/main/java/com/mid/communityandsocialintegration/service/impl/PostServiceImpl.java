package com.mid.communityandsocialintegration.service.impl;

import com.mid.communityandsocialintegration.dto.PostDto;
import com.mid.communityandsocialintegration.dto.UserDto;
import com.mid.communityandsocialintegration.entity.Following;
import com.mid.communityandsocialintegration.entity.Post;
import com.mid.communityandsocialintegration.exception.CustomException;
import com.mid.communityandsocialintegration.repository.FollowingRepository;
import com.mid.communityandsocialintegration.repository.PostRepository;
import com.mid.communityandsocialintegration.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final FollowingRepository followingRepository;
    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, FollowingRepository followingRepository, UserServiceImpl userService, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.followingRepository = followingRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto create(Post post) throws CustomException {
        UserDto user  = modelMapper.map(userService.getCurrentUserProfile(), UserDto.class);
        if (user != null){
            post.setUserId(user.getUserID());
            post.setLocalDateTime(LocalDateTime.now());
            post = postRepository.save(post);
            PostDto postDto = modelMapper.map(post, PostDto.class);
            postDto.setUser(user);
            return postDto;
        }else{
            throw new CustomException("User doesn't exists");
        }
    }

    @Override
    public void delete(Long postId) throws CustomException {
        Optional<Post> existingPost = postRepository.findById(postId);
        UserDto user = userService.getCurrentUserProfile();
        if (existingPost.isPresent()){
            if(!existingPost.get().isGroupPost()) {
                if(existingPost.get().getUserId().contains(user.getUserID()))
                    postRepository.delete(existingPost.get());
                else throw new CustomException("Permission denied. You don't have the authority to delete post.");
            }else throw new CustomException("Group post can not be deleted");
        }else{
            throw new CustomException("Post doesn't exists");
        }
    }

    @Override
    public PostDto getPost(Long id) throws CustomException {
        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()){
            PostDto postDto = modelMapper.map(existingPost.get(), PostDto.class);
            postDto.setLikedUsers(new ArrayList<>());
            postDto.setUser(userService.getUserProfileById(existingPost.get().getUserId()));
            for (String userId : existingPost.get().getLikedUsersIds()){
                UserDto user = userService.getUserProfileById(userId);
                if (user.getUserID() != null){
                    postDto.getLikedUsers().add(user);
                }
            }
            return postDto;
        }else{
            throw new CustomException("Post doesn't exists");
        }
    }

    @Override
    public Post likePost(Long postId) throws CustomException {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            UserDto user = userService.getCurrentUserProfile();
            if (!post.get().getLikedUsersIds().contains(user.getUserID()))
                post.get().getLikedUsersIds().add(user.getUserID());
            else post.get().getLikedUsersIds().remove(user.getUserID());
            post.get().setLikes((long) post.get().getLikedUsersIds().size());
            return postRepository.save(post.get());
        }
        else throw new CustomException("Post not found to like");
    }
    @Override
    public List<Post> newsFeedByFollowPreference(){
        UserDto userDto = userService.getCurrentUserProfile();
        Following following = followingRepository.findByFollowerId(userDto.getUserID()).get(0);
        List<Post> posts = new ArrayList<>();
        for (String followingId : following.getFollowingUsersIds()){
            posts.addAll(postRepository.findByUserIdOrderByLocalDateTimeDesc(followingId));
        }
        return posts;
    }

}
