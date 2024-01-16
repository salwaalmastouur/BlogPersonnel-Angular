package com.blogProject.blog.Repositories;

import com.blogProject.blog.Modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email,String password);
    public User findByUserId(Long userId);
}
