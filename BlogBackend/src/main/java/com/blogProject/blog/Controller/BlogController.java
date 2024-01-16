package com.blogProject.blog.Controller;

import com.blogProject.blog.Modal.Blog;
import com.blogProject.blog.Services.BlogService;
import com.blogProject.blog.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @PostMapping("/addBlog")
    @ResponseBody
    public Blog addBlog(@RequestBody Blog blog, Principal principal) {
        return blogService.addBlog(blog, userService.getUserId(principal));
    }

    @GetMapping("/getBlogs")
    public List<Blog> getBlog()
    {
        return blogService.getBlogList();
    }
    @GetMapping("/getBlogById/{postId}")
    public Blog getBlogById(@PathVariable("postId")Long id)
    {
        return blogService.getBlogById(id);
    }

    @GetMapping("/getBlogByUserId")
    public List<Blog> getBlogByUID(Principal principal)
    {
        Long id = userService.getUserByEmail(principal.getName()).getUserId();
        System.out.println(blogService.getBlogsByUserId(id).toString());
        return blogService.getBlogsByUserId(id);
    }
    @PostMapping("/editBlog")
    public Blog editBlog(@RequestBody Blog blog)
    {
        System.out.println(blog.toString());
        System.out.println("After edit" + blogService.editB(blog).toString());
        return blogService.editB(blog);

    }
    @DeleteMapping("/deleteBlog/{id}")
    public String delete(@PathVariable("id") Long id)
    {
    return blogService.deleteBlog(id);
    }

    @GetMapping("/getBlogByFollowingUserId/{userId}")
    public List<Blog> getBlogs(@PathVariable("userId") Long userId)
    {
        System.out.println(blogService.getBlogsByUserId(userId).toString());
        return blogService.getBlogsByUserId(userId);
    }

    @Transactional
    @GetMapping("/archivePost/{blogId}")
    public String archivePost(@PathVariable("blogId") Long blogId,Principal principal)
    {
        return blogService.makePrivate(blogId,principal);
    }

    @GetMapping("/removePrivate/{blogId}")
    public String removePrivate(@PathVariable("blogId")Long blogId,Principal principal)
    {
        return blogService.removePrivate(blogId,principal);
    }
}
