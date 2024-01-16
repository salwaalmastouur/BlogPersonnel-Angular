package com.blogProject.blog.Repositories;

import com.blogProject.blog.Modal.Following;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollwingRepository extends JpaRepository<Following,Long> {
    List<Following> findByUserIdUserId(Long id);
    List<Following> findFollowingByUserIdUserId(Long id);
    Following findByUserIdUserIdAndFollowingIdUserId(Long userId, Long FollowingId);
    String deleteByUserIdUserIdAndAndFollowingIdUserId(Long userId, Long followingId);
}
