package com.blogProject.blog.Modal;

import javax.persistence.*;

@Entity
public class followers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fId;
    @ManyToOne
    private User userId;
    @ManyToOne
    private User followerId;
    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public User getFollowerId() {
        return followerId;
    }

    public void setFollowerId(User followerId) {
        this.followerId = followerId;
    }


}
