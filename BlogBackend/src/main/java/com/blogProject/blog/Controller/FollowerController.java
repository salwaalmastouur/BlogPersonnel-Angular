package com.blogProject.blog.Controller;

import com.blogProject.blog.Modal.followers;
import com.blogProject.blog.Repositories.UserRepository;
import com.blogProject.blog.Services.FollowerService;
import com.blogProject.blog.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
public class FollowerController {

    @Autowired
    private UserService userService;
    @Autowired
    private FollowerService followerService;

    @GetMapping("/followUser/{id}")
    public String addFollower(@PathVariable("id") Long id, Principal principal)
    {

        Long currentUserId = userService.getUserByEmail(principal.getName()).getUserId();

        if(id==currentUserId)
            return "\"User cant add himself\"";

        return followerService.addFollower(currentUserId,id);
    }

    @GetMapping("/checkUser/{id}")
    public String checkUserIfFollowing(@PathVariable("id") Long id,Principal principal)
    {
        Long currentUser = userService.getUserByEmail(principal.getName()).getUserId();
        return followerService.checkUserForFollowing(currentUser,id);
    }
    @Transactional
    @DeleteMapping("/Unfollow/{id}")
    public String unfollow(@PathVariable("id")Long id, Principal principal)
    {
        Long currentUser = userService.getUserByEmail(principal.getName()).getUserId();
        return followerService.unfollow(currentUser,id);
    }
}
