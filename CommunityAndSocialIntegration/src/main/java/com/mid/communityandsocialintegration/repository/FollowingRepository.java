package com.mid.communityandsocialintegration.repository;

import com.mid.communityandsocialintegration.entity.Following;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowingRepository extends JpaRepository<Following, Long> {

    List<Following> findByFollowerId(String followerId);
}
