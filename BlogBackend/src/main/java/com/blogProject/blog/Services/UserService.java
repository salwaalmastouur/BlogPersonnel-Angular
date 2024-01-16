package com.blogProject.blog.Services;

import com.blogProject.blog.Modal.User;
import com.blogProject.blog.Repositories.BlogRepository;
import com.blogProject.blog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> getUser()
    {
        return repo.findAll();
    }
    public User getUserByEmail(String email)
    {
        return repo.findByEmail(email);
    }
    public Long getUserId(Principal principal) {
        String email = principal.getName();
        return repo.findByEmail(email).getUserId();
    }

    public User findByEmailAndPassword(String email,String password)
    {
        return repo.findByEmailAndPassword(email, password);
    }

    public String addUserToDB(User user)
    {
        repo.save(user);
        return "added";
    }
    public User findByUserId(Long userId)
    {
        return  repo.findByUserId(userId);
    }
    public User getuserProfile(Principal principal){
        return repo.findByEmail(principal.getName());
    }
    public User editUserProfile(User user){
        User ouser = repo.findByUserId(user.getUserId());
        ouser.setUserId(user.getUserId());
        ouser.setEmail(user.getEmail());
        ouser.setMobileNo(user.getMobileNo());
        ouser.setPassword(user.getPassword());
        ouser.setName(user.getName());
        repo.saveAndFlush(ouser);
        return ouser;
    }

    public List<User> getUserList(String name,Long currentUser)
    {

        List<User> list = repo.findAll();
        List<User> users = new ArrayList<>();

        for(int i=0;i<list.size();i++)
        {
            if(currentUser!=list.get(i).getUserId())
            if(list.get(i).getName().toLowerCase().contains(name.toLowerCase()))
                users.add(list.get(i));
        }
        if(users.size()==0)
            return new ArrayList<>();

        else
            return users;


    }
}
