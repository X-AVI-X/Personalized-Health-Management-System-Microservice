package com.mid.communityandsocialintegration.controller;

import com.mid.communityandsocialintegration.dto.PostDto;
import com.mid.communityandsocialintegration.dto.UserIdListDto;
import com.mid.communityandsocialintegration.entity.Comment;
import com.mid.communityandsocialintegration.entity.Post;
import com.mid.communityandsocialintegration.entity.UserGroup;
import com.mid.communityandsocialintegration.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface CommunityController {

    @PostMapping("/post/create")
    ResponseEntity<?> createPostByUser(@RequestBody Post post) throws CustomException;

    @DeleteMapping("/post/{id}")
    ResponseEntity<?> deletePost(@PathVariable Long id) throws CustomException;

    @GetMapping("/post/{postId}")
    ResponseEntity<?> getPost(@PathVariable Long postId) throws CustomException;

    @PostMapping("group/create")
    ResponseEntity<?> createGroup (@RequestBody UserGroup group);

    @PostMapping("group/{groupId}/post/create")
    ResponseEntity<?> createGroupPost(@RequestBody Post post, @PathVariable Long groupId) throws CustomException;

    @DeleteMapping("group/delete/{id}")
    ResponseEntity<?> deleteGroup(@PathVariable Long id) throws CustomException;

    @GetMapping("/group/get/all")
    ResponseEntity<?> getAllGroups();

    @GetMapping("/group/get/{id}")
    ResponseEntity<?> getGroupById(@PathVariable Long id) throws CustomException;

    @PutMapping("group/{groupId}/member/add")
    ResponseEntity<?> addMembersToGroup(@RequestBody UserIdListDto userIdListDto, @PathVariable Long groupId) throws CustomException;

    @PutMapping("group/{groupId}/member/remove/{userId}")
    ResponseEntity<?> removeMemberFromGroup(@PathVariable Long groupId, @PathVariable String userId) throws CustomException;

    @PutMapping("/group/{groupId}/post/remove/{postId}")
    ResponseEntity<?> removePostFromGroup(@PathVariable Long groupId, @PathVariable Long postId) throws CustomException;

    @PostMapping("post/{postId}/comment/add")
    ResponseEntity<?> addComment (@RequestBody Comment comment, @PathVariable Long postId) throws CustomException;

    @DeleteMapping("post/{postId}/comment/{commentId}/delete")
    ResponseEntity<?> removeComment(@PathVariable Long postId, @PathVariable Long commentId) throws CustomException;

    @PutMapping("/post/{postId}/like/")
    ResponseEntity<Post> likePost(@PathVariable Long postId) throws CustomException;

    @PostMapping("/follow/user/{followingId}")
    ResponseEntity<?> followUser(@PathVariable String followingId) throws CustomException;

    @GetMapping("/newsfeed")
    ResponseEntity<?> getNewsFeed() throws CustomException;
}
