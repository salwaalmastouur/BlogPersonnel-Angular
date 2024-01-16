package com.blogProject.blog.Repositories;

import com.blogProject.blog.Modal.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Long> {
    List<Comments> findByBlogIdPostId(Long id);
    String deleteByCommentId(Long id);
}
