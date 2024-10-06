package com.mid.communityandsocialintegration.service.impl;

import com.mid.communityandsocialintegration.dto.CommentDto;
import com.mid.communityandsocialintegration.dto.UserDto;
import com.mid.communityandsocialintegration.entity.Comment;
import com.mid.communityandsocialintegration.entity.Post;
import com.mid.communityandsocialintegration.exception.CustomException;
import com.mid.communityandsocialintegration.repository.CommentRepository;
import com.mid.communityandsocialintegration.repository.PostRepository;
import com.mid.communityandsocialintegration.response.ActionResponse;
import com.mid.communityandsocialintegration.service.CommentService;
import com.mid.communityandsocialintegration.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final UserServiceImpl userService;

    public CommentServiceImpl(CommentRepository commentRepository, PostService postService, PostRepository postRepository, ModelMapper modelMapper, UserServiceImpl userService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public CommentDto addComment(Long postId, Comment comment) throws CustomException {
        Post post = postRepository.findById(postId).orElseThrow(()-> new CustomException("Post not found."));
        UserDto userDto = userService.getCurrentUserProfile();
        comment.setUserId(userDto.getUserID());
        comment.setDateTime(LocalDateTime.now());
        comment = commentRepository.save(comment);
        post.getComments().add(comment);
        postRepository.save(post);
        CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
        commentDto.setUser(userDto);
        return commentDto;
    }
    @Override
    public ActionResponse deleteComment (Long postId, Long commentId) throws CustomException {
        Optional<Comment> comment = commentRepository.findById(commentId);
        Post post = postRepository.findById(postId).orElseThrow(()-> new CustomException("Post not found"));
        UserDto userDto = userService.getCurrentUser();
        if (comment.isPresent()){
            if (Objects.equals(comment.get().getUserId(), userDto.getUserID())) {
                post.getComments().remove(comment.get());
                commentRepository.delete(comment.get());
                postRepository.save(post);
            }else throw new CustomException("Action denied. Not your comment to delete.");
            return new ActionResponse("Comment deleted.");
        } else throw new CustomException("Error deleting comment");
    }
}
