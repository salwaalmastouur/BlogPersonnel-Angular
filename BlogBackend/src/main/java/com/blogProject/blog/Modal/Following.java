package com.blogProject.blog.Modal;

import javax.persistence.*;

@Entity
public class Following {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long folId;
    @ManyToOne
    private User userId;
    @ManyToOne
    private User followingId;

    public Long getFolId() {
        return folId;
    }

    public void setFolId(Long folId) {
        this.folId = folId;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(User user) {
        this.userId = user;
    }

    public User getFollowingId() {
        return followingId;
    }

    public void setFollowingId(User followingId) {
        this.followingId = followingId;
    }

    @Override
    public String toString() {
        return "Following{" +
                "folId=" + folId +
                ", user=" + userId +
                ", followingId=" + followingId +
                '}';
    }
}

