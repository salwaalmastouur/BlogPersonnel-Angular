package com.blogProject.blog.Repositories;

import com.blogProject.blog.Modal.followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends JpaRepository<followers,Long> {
    public List<followers> findByUserIdUserId(Long id);
    String deleteByUserIdUserIdAndAndFollowerIdUserId(Long userId, Long followerId);

}
