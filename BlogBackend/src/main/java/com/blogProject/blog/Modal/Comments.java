package com.blogProject.blog.Modal;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long commentId;
    @ManyToOne
    private User userId;
    @ManyToOne
    private Blog blogId;
    private String commentContent;
    private Date date;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Blog getBlogId() {
        return blogId;
    }

    public void setBlogId(Blog blogId) {
        this.blogId = blogId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
