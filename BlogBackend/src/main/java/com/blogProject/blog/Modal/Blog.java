package com.blogProject.blog.Modal;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;
    private Date date;
    private String title;
    private String content;
    @OneToOne
    private User userId;
    private boolean privateBlog = false;

    public boolean isPrivateBlog() {
        return privateBlog;
    }

    public void setPrivateBlog(boolean privateBlog) {
        this.privateBlog = privateBlog;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "postId=" + postId +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                '}';
    }
}
