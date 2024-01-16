package com.blogProject.blog.Repositories;

import com.blogProject.blog.Modal.Blog;
import com.blogProject.blog.Modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    public List<Blog> getBlogByUserId(User user);
    public Blog getBlogByPostId(Long id);
    String deleteBlogByPostId(Long id);

}
