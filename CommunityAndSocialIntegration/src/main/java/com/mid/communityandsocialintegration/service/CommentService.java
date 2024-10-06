package com.mid.communityandsocialintegration.service;

import com.mid.communityandsocialintegration.dto.CommentDto;
import com.mid.communityandsocialintegration.entity.Comment;
import com.mid.communityandsocialintegration.exception.CustomException;
import com.mid.communityandsocialintegration.response.ActionResponse;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CommentDto addComment(Long postId, Comment comment) throws CustomException;

    ActionResponse deleteComment(Long postId, Long commentId) throws CustomException;
}
