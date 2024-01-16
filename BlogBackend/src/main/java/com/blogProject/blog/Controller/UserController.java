package com.blogProject.blog.Controller;

import com.blogProject.blog.Modal.Following;
import com.blogProject.blog.Modal.User;
import com.blogProject.blog.Modal.followers;
import com.blogProject.blog.Services.FollowerService;
import com.blogProject.blog.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userS;

    @Autowired
    private FollowerService followerService;

    @GetMapping("/loginUser")
    public String logIn() {
        return "\"logged in\"";
    }

   @GetMapping("/user/{id}")
   public User getUserByUserId(@PathVariable("id") Long id)
   {
       return userS.findByUserId(id);
   }

    @PostMapping("/enterUsers")
    public User addUser(@RequestBody User user) {
        userS.addUserToDB(user);
        System.out.println(user.toString());
        return user;
    }

    @GetMapping("/user/{email}/{password}")
    public User getNameAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {

        return userS.findByEmailAndPassword(email, password);
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            request.getSession().invalidate();
        }
        return "/home";

    }

    @GetMapping("/getUser")
    public User getCurrentUser(Principal principal)
    {
        return userS.getuserProfile(principal);
    }
    @PostMapping("/editUser")
    public User editCurrentUser(@RequestBody User user)
    {
        return userS.editUserProfile(user);
    }
    @GetMapping("/showFollowers")
    public List<followers> showFollowers(Principal principal){
        Long userId = userS.getUserByEmail(principal.getName()).getUserId();

       return followerService.showFollowers(userId);
    }
    @GetMapping("/showFollowing")
    public List<Following> showFollowing(Principal principal)
    {
        Long userId = userS.getUserByEmail(principal.getName()).getUserId();
        return followerService.showFollowing(userId);

    }
    @GetMapping("/getUserById/{id}")
    public User showUserById(@PathVariable("id") Long id)
    {
        return userS.findByUserId(id);
    }

    @GetMapping("/searchUser/{name}")
    public List<User> getUserList(@PathVariable("name") String name,Principal principal)
    {
        Long currentId = userS.getUserByEmail(principal.getName()).getUserId();
        return userS.getUserList(name,currentId);
    }
}
