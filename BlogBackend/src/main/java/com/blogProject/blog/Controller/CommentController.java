package com.blogProject.blog.Controller;

import com.blogProject.blog.Modal.Comments;
import com.blogProject.blog.Services.CommentService;
import com.blogProject.blog.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @PostMapping("/addComments/{blogId}")
    @ResponseBody
    public Comments addComment(@RequestBody Comments comment, Principal principal,@PathVariable("blogId") Long blogId)
    {
        return commentService.addComment(userService.getUserId(principal),comment,blogId);
    }
    @GetMapping("/showComments/{blogId}")
    public List<Comments> showComments(@PathVariable("blogId")Long blogId)
    {
        System.out.println(commentService.showComments(blogId));
        return commentService.showComments(blogId);
    }
    @Transactional
    @DeleteMapping("/deleteComment/{commentId}")
    public String delete(@PathVariable("commentId") Long cId,Principal principal)
    {
        return commentService.deleteComment(cId);
    }

}
