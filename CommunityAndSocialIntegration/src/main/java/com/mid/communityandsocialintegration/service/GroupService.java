package com.mid.communityandsocialintegration.service;

import com.mid.communityandsocialintegration.dto.PostDto;
import com.mid.communityandsocialintegration.dto.UserGroupDto;
import com.mid.communityandsocialintegration.entity.Post;
import com.mid.communityandsocialintegration.entity.UserGroup;
import com.mid.communityandsocialintegration.exception.CustomException;
import com.mid.communityandsocialintegration.response.ActionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {


    UserGroup create(UserGroup userGroup);

    List<UserGroup> getAll();

    UserGroupDto getGroup(Long id) throws CustomException;

    void delete(Long id) throws CustomException;

    UserGroupDto addMembers(Long groupId, List<String> ids) throws CustomException;

    ActionResponse removeMember(Long groupId, String userId) throws CustomException;

    PostDto addPost(Long groupId, Post post) throws CustomException;

    ActionResponse removePost(Long groupId, Long postId) throws CustomException;
}
