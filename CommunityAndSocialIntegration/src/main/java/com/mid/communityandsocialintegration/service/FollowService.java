package com.mid.communityandsocialintegration.service;

import com.mid.communityandsocialintegration.entity.Following;
import com.mid.communityandsocialintegration.exception.CustomException;
import org.springframework.stereotype.Service;

@Service
public interface FollowService {
    Following followOrUnfollowUser(String id) throws CustomException;
}
