package com.blogProject.blog.Services;

import com.blogProject.blog.Modal.Blog;
import com.blogProject.blog.Modal.User;
import com.blogProject.blog.Repositories.BlogRepository;
import com.blogProject.blog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    public Blog addBlog(Blog blog, Long userId) {
        User currentUser = userRepository.findByUserId(userId);
        blog.setUserId(currentUser);
        return blogRepository.save(blog);

    }

    public List<Blog> getBlogList() {
        return blogRepository.findAll();
    }
    public Blog getBlogById(Long id)
    {
        return blogRepository.findById(id).orElse(new Blog());
    }
    public List<Blog> getBlogsByUserId(Long id)
    {
        User u = userRepository.findByUserId(id);
        return blogRepository.getBlogByUserId(u);
    }
    public Blog editB(Blog b)
    {
        Blog bb = blogRepository.getBlogByPostId(b.getPostId());
        bb.setTitle(b.getTitle());
        bb.setContent(b.getContent());
        blogRepository.saveAndFlush(bb);
        return bb;

    }
    public String deleteBlog(Long id)
    {
        blogRepository.deleteById(id);
        return"\"Deleted\"";
    }
    public String makePrivate(Long blogId,Principal principal)
    {
       Blog oldBlog = getBlogById(blogId);
       oldBlog.setUserId(oldBlog.getUserId());
       oldBlog.setPrivateBlog(true);
        System.out.println(oldBlog.toString());
        blogRepository.saveAndFlush(oldBlog);
        return "\"Blog Privated\"";

    }
    public String removePrivate(Long blogId,Principal principal)
    {
        Blog oldBlog = getBlogById(blogId);
        oldBlog.setUserId(oldBlog.getUserId());
        oldBlog.setPrivateBlog(false);
        System.out.println(oldBlog.toString());
        blogRepository.saveAndFlush(oldBlog);
        return "\"Removed From Private\"";

    }

}
