package com.example.ownwebsite.models.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Table(name = "comments")
@Entity
public class Comment extends BaseEntity{

    private User user;
    private String commentContent;
    private Instant postedOn;

    public Comment() {
    }

    @ManyToOne
    public User getUser() {
        return user;
    }


    public Comment setUser(User user) {
        this.user = user;
        return this;
    }


    @Column(name = "comment_content", nullable = false)
    @Length(min = 5)
    public String getCommentContent() {
        return commentContent;
    }

    public Comment setCommentContent(String commentContent) {
        this.commentContent = commentContent;
        return this;
    }

    @Column(name = "posted_on", nullable = false)
    public Instant getPostedOn() {
        return postedOn;
    }

    public Comment setPostedOn(Instant postedOn) {
        this.postedOn = postedOn;
        return this;
    }


}
