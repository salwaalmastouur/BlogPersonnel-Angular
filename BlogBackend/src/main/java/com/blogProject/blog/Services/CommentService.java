package com.blogProject.blog.Services;

import com.blogProject.blog.Modal.Blog;
import com.blogProject.blog.Modal.Comments;
import com.blogProject.blog.Modal.User;
import com.blogProject.blog.Repositories.CommentRepository;
import com.blogProject.blog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService
{
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogService blogService;
    public Comments addComment(Long userId, Comments comment,Long blogId)
    {
       comment.setBlogId(blogService.getBlogById(blogId));
        comment.setUserId(userRepository.findByUserId(userId));
        commentRepository.save(comment);
        return comment;
    }
    public List<Comments> showComments(Long blogId)
    {
        return commentRepository.findByBlogIdPostId(blogId);
    }
    public String deleteComment(Long cid)
    {
        commentRepository.deleteByCommentId(cid);
        return "\"deleted comment\"";
    }
}
