package com.mid.communityandsocialintegration.service.impl;

import com.mid.communityandsocialintegration.dto.PostDto;
import com.mid.communityandsocialintegration.dto.UserDto;
import com.mid.communityandsocialintegration.dto.UserGroupDto;
import com.mid.communityandsocialintegration.entity.Post;
import com.mid.communityandsocialintegration.entity.UserGroup;
import com.mid.communityandsocialintegration.exception.CustomException;
import com.mid.communityandsocialintegration.repository.GroupRepository;
import com.mid.communityandsocialintegration.repository.PostRepository;
import com.mid.communityandsocialintegration.response.ActionResponse;
import com.mid.communityandsocialintegration.service.GroupService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final UserServiceImpl userService;

    public GroupServiceImpl(GroupRepository groupRepository, PostRepository postRepository, ModelMapper modelMapper, UserServiceImpl userService) {
        this.groupRepository = groupRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }
    @Override
    public UserGroup create(UserGroup userGroup){
        return groupRepository.save(userGroup);
    }
    @Override
    public List<UserGroup> getAll (){
        return groupRepository.findAll();
    }
    @Override
    public UserGroupDto getGroup (Long id) throws CustomException {
        UserGroupDto userGroupDto = new UserGroupDto();
        UserGroup userGroup = groupRepository.findById(id).orElseThrow(()-> new CustomException("Group not found"));
        userGroupDto = modelMapper.map(userGroup, UserGroupDto.class);
        userGroupDto.setJoinedUsers(new ArrayList<>());
        for (String userId : userGroup.getJoinedUsersIds()){
            UserDto userDto = userService.getUserProfileById(userId);
            userGroupDto.getJoinedUsers().add(userDto);
        }
        return userGroupDto;
    }
    @Override
    public void delete(Long id) throws CustomException {
        Optional<UserGroup> group = groupRepository.findById(id);
        if (group.isPresent()){
            groupRepository.delete(group.get());
        }else{
            throw new CustomException("Group doesn't exists");
        }
    }
    @Override
    public UserGroupDto addMembers (Long groupId, List<String> ids) throws CustomException {
        Optional<UserGroup> group = groupRepository.findById(groupId);
        UserGroup userGroup;
        if (group.isPresent()){
            if (!new HashSet<>(group.get().getJoinedUsersIds()).containsAll(ids)){
                group.get().getJoinedUsersIds().addAll(ids);
            }else throw new CustomException("One/more user already added.");
            try {
                userGroup = groupRepository.save(group.get());
            } catch (Exception e){
                    throw new CustomException("User already added");
                }
        }else{
            throw new CustomException("Group doesn't exists");
        }
        UserGroupDto userGroupDto = modelMapper.map(userGroup, UserGroupDto.class);
        userGroupDto.setJoinedUsers(new ArrayList<>());
        for (String id : userGroup.getJoinedUsersIds()){
            userGroupDto.getJoinedUsers().add(userService.getUserProfileById(id));
        }
        return userGroupDto;
    }
    @Override
    public ActionResponse removeMember (Long groupId, String userId) throws CustomException {
        Optional<UserGroup> group = groupRepository.findById(groupId);
        Optional<UserDto> user = Optional.ofNullable(userService.getUserProfileById(userId));
        if (group.isPresent()) {
            if (user.isPresent()) {
                if (group.get().getJoinedUsersIds().contains(user.get().getUserID())) {
                    group.get().getJoinedUsersIds().remove(user.get().getUserID());
                    groupRepository.save(group.get());
                    return new ActionResponse("Successfully removed");
                }else {
                    throw new CustomException("User already removed");
                }

            } else {
                    throw new CustomException("User doesn't exists");
                }
        } else {
                throw new CustomException("Group doesn't exists");
            }
    }

    @Override
    public PostDto addPost(Long groupId, Post post) throws CustomException {
        UserDto user  = modelMapper.map(userService.getCurrentUserProfile(), UserDto.class);

        Optional<UserGroup> group = groupRepository.findById(groupId);

        if (group.isPresent() && group.get().getJoinedUsersIds().contains(user.getUserID())){
            post.setUserId(user.getUserID());
            post.setLocalDateTime(LocalDateTime.now());
            post.setGroupPost(true);
            post = postRepository.save(post);
            PostDto postDto = modelMapper.map(post, PostDto.class);
            postDto.setUser(user);
            group.get().getPosts().add(post);
            groupRepository.save(group.get());
            return postDto;
        }else{
            throw new CustomException("Group or User doesn't exists");
        }
    }
    @Override
    public ActionResponse removePost (Long groupId, Long postId) throws CustomException {
        Optional<UserGroup> group = groupRepository.findById(groupId);
        Optional<Post> post = postRepository.findById(postId);
        UserDto userDto = userService.getCurrentUserProfile();

        if (post.isPresent()) {
            if(Objects.equals(post.get().getUserId(), userDto.getUserID())) {
                if (group.isPresent() && group.get().getPosts().contains(post.get())) {
                    group.get().getPosts().removeIf((p) -> p.getId().equals(postId));
                    try {
                        postRepository.delete(Objects.requireNonNull(postRepository.findById(postId).orElse(null)));
                        groupRepository.save(group.get());
                    } catch (Exception e) {
                        throw new CustomException("Post doesn't exists");
                    }
                    return new ActionResponse("Post removed.");
                } else {
                    throw new CustomException("Group or Post doesn't exists");
                }
            }else throw new CustomException("Action denied. Post not owned by current user.");
        }else throw new CustomException("Post doesn't exists");
    }
}
