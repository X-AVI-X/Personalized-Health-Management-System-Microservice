package com.mid.communityandsocialintegration.controller.impl;

import com.mid.communityandsocialintegration.controller.CommunityController;
import com.mid.communityandsocialintegration.dto.UserIdListDto;
import com.mid.communityandsocialintegration.entity.Comment;
import com.mid.communityandsocialintegration.entity.Post;
import com.mid.communityandsocialintegration.entity.UserGroup;
import com.mid.communityandsocialintegration.exception.CustomException;
import com.mid.communityandsocialintegration.service.CommentService;
import com.mid.communityandsocialintegration.service.FollowService;
import com.mid.communityandsocialintegration.service.GroupService;
import com.mid.communityandsocialintegration.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("community")
public class CommunityControllerImpl implements CommunityController {

    private final PostService postService;
    private final CommentService commentService;
    private final GroupService groupService;
    private final FollowService followService;


    public CommunityControllerImpl(PostService postService, CommentService commentService, GroupService groupService, FollowService followService) {
        this.postService = postService;
        this.commentService = commentService;
        this.groupService = groupService;
        this.followService = followService;
    }
    @Override
    @PostMapping("/post/create")
    public ResponseEntity<?> createPostByUser(@RequestBody Post post) throws CustomException {
        return new ResponseEntity<>(postService.create(post), HttpStatus.CREATED);
    }
    @Override
    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) throws CustomException {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getPost(@PathVariable Long postId) throws CustomException {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @Override
    @PostMapping("group/create")
    public ResponseEntity<?> createGroup(@RequestBody UserGroup group){
        return ResponseEntity.ok(groupService.create(group));
    }
    @Override
    @PostMapping("/group/{groupId}/post/create")
    public ResponseEntity<?> createGroupPost(@RequestBody Post post, @PathVariable Long groupId) throws CustomException {
        return ResponseEntity.ok(groupService.addPost(groupId, post));
    }

    @Override
    @DeleteMapping("/group/delete/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) throws CustomException {
        groupService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Override
    @GetMapping("/group/get/all")
    public ResponseEntity<?> getAllGroups(){
        return ResponseEntity.ok(groupService.getAll());
    }
    @Override
    @GetMapping("/group/get/{id}")
    public ResponseEntity<?> getGroupById(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(groupService.getGroup(id));
    }

    @Override
    @PutMapping("/group/{groupId}/member/add")
    public ResponseEntity<?> addMembersToGroup(@RequestBody UserIdListDto userIdListDto, @PathVariable Long groupId) throws CustomException {
        return ResponseEntity.ok(groupService.addMembers(groupId,userIdListDto.getUserIds()));
    }

    @Override
    @PutMapping("/group/{groupId}/member/remove/{userId}")
    public ResponseEntity<?> removeMemberFromGroup(@PathVariable Long groupId, @PathVariable String userId) throws CustomException {
        return ResponseEntity.ok(groupService.removeMember(groupId, userId));
    }

    @Override
    @PutMapping("/group/{groupId}/post/remove/{postId}")
    public ResponseEntity<?> removePostFromGroup(@PathVariable Long groupId, @PathVariable Long postId) throws CustomException {
        return ResponseEntity.ok(groupService.removePost(groupId, postId));
    }

    @Override
    @PostMapping("/post/{postId}/comment/add")
    public ResponseEntity<?> addComment(@RequestBody Comment comment, @PathVariable Long postId) throws CustomException {
        return ResponseEntity.ok(commentService.addComment(postId, comment));
    }

    @Override
    @DeleteMapping("/post/{postId}/comment/{commentId}/delete")
    public ResponseEntity<?> removeComment(@PathVariable Long postId, @PathVariable Long commentId) throws CustomException {
        return ResponseEntity.ok(commentService.deleteComment(postId, commentId));
    }

    @Override
    @PutMapping("/post/{postId}/like")
    public ResponseEntity<Post> likePost(@PathVariable Long postId) throws CustomException {
        return ResponseEntity.ok(postService.likePost(postId));
    }

    @Override
    @PostMapping("/follow/user/{followingId}")
    public ResponseEntity<?> followUser(@PathVariable String followingId) throws CustomException {
        return ResponseEntity.ok(followService.followOrUnfollowUser(followingId));
    }

    @Override
    @GetMapping("/newsfeed")
    public ResponseEntity<?> getNewsFeed() throws CustomException {
        return ResponseEntity.ok(postService.newsFeedByFollowPreference());
    }
}
