package com.mid.communityandsocialintegration.repository;

import com.mid.communityandsocialintegration.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<UserGroup, Long> {

}
