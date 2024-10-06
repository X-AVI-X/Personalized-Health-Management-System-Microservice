package com.mid.communityandsocialintegration.repository;

import com.mid.communityandsocialintegration.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
