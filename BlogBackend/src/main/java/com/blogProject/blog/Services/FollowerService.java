package com.blogProject.blog.Services;

import com.blogProject.blog.Modal.Following;
import com.blogProject.blog.Modal.User;
import com.blogProject.blog.Modal.followers;
import com.blogProject.blog.Repositories.FollowerRepository;
import com.blogProject.blog.Repositories.FollwingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    @Autowired
    private FollwingRepository follwingRepository;

    @Autowired
    private UserService userService;
    public String addFollower(Long currentUserId, Long followerId)
    {
        followers followerObj = new followers();
        //adding followed user in current user's database
        User user = userService.findByUserId(currentUserId);
        Following follwingObj = new Following();
        follwingObj.setUser(user);
        User user1 = userService.findByUserId(followerId);
        follwingObj.setFollowingId(user1);
        follwingRepository.save(follwingObj);

        //adding a follower in the follwed user database
        User user2 = userService.findByUserId(followerId);
        User user3 = userService.findByUserId(currentUserId);
        followerObj.setFollowerId(user3);
        followerObj.setUserId(user2);
        followerRepository.save(followerObj);

        return "\"Followed\"";
    }
    public List<followers> showFollowers(Long id)
    {
        return followerRepository.findByUserIdUserId(id);
    }
    public List<Following> showFollowing(Long id)
    {

        return follwingRepository.findFollowingByUserIdUserId(id);
    }
    public String checkUserForFollowing(Long currentUser, Long FollowingId)
    {
        Following f = (follwingRepository.findByUserIdUserIdAndFollowingIdUserId(currentUser,FollowingId));
       if(f!=null)
           return "\"true\"";
       else
           return "\"false\"";
    }
    public String unfollow(Long currentId, Long followerId){
        follwingRepository.deleteByUserIdUserIdAndAndFollowingIdUserId(currentId,followerId);


        followerRepository.deleteByUserIdUserIdAndAndFollowerIdUserId(followerId,currentId);

        return "\"Un-Followed\"";

    }
}
