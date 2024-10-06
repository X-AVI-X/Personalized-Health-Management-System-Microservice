package com.mid.communityandsocialintegration.service.impl;

import com.mid.communityandsocialintegration.dto.UserDto;
import com.mid.communityandsocialintegration.entity.Following;
import com.mid.communityandsocialintegration.exception.CustomException;
import com.mid.communityandsocialintegration.repository.FollowingRepository;
import com.mid.communityandsocialintegration.service.FollowService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FollowServiceImpl implements FollowService {
    private final FollowingRepository followingRepository;
    private final UserServiceImpl userService;

    public FollowServiceImpl(FollowingRepository followingRepository, UserServiceImpl userService) {
        this.followingRepository = followingRepository;
        this.userService = userService;
    }

    @Override
    public Following followOrUnfollowUser(String id) throws CustomException {
        UserDto currentUser = userService.getCurrentUserProfile();
        UserDto followedUser;
        Following following=new Following();
        try {
            followedUser = userService.getUserProfileById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException("Following id invalid");
        }
        if (followedUser!=null){
            try {
                following = followingRepository.findByFollowerId(currentUser.getUserID()).get(0);
            }catch (Exception e){
                following.setFollowerId(currentUser.getUserID());
                following.setFollowingUsersIds(new ArrayList<>());
                following.getFollowingUsersIds().add(id);
                following.setFollowingCount(following.getFollowingUsersIds().size());
                return followingRepository.save(following);
            }
            if (following != null){
                if (following.getFollowingUsersIds().contains(followedUser.getUserID())){
                    following.getFollowingUsersIds().remove(followedUser.getUserID());
                }else {
                    following.getFollowingUsersIds().add(followedUser.getUserID());
                }
                following.setFollowingCount(following.getFollowingUsersIds().size());
                return followingRepository.save(following);
            }
        }throw new CustomException("Following id invalid");
    }
}
