package com.example.ownwebsite.models.service;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CommentServiceModel {

    private String user;
    private String commentContent;
    private String postedOn;

    public CommentServiceModel() {
    }

    @NotNull
    public String getUser() {
        return user;
    }

    public CommentServiceModel setUser(String user) {
        this.user = user;
        return this;
    }

    @NotNull
    @Length(min = 5)
    public String getCommentContent() {
        return commentContent;
    }

    public CommentServiceModel setCommentContent(String commentContent) {
        this.commentContent = commentContent;
        return this;
    }

    @NotNull
    public String getPostedOn() {
        return postedOn;
    }

    public CommentServiceModel setPostedOn(String postedOn) {
        this.postedOn = postedOn;
        return this;
    }
}
