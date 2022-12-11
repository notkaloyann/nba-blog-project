package com.example.ownwebsite.models.view;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CommentViewModel {

    private String user;
    private String commentContent;
    private String postedOn;

    public CommentViewModel() {
    }


    @NotNull
    public String getUser() {
        return user;
    }

    public CommentViewModel setUser(String user) {
        this.user = user;
        return this;
    }

    @NotNull
    @Length(min = 5)
    public String getCommentContent() {
        return commentContent;
    }

    public CommentViewModel setCommentContent(String commentContent) {
        this.commentContent = commentContent;
        return this;
    }

    @NotNull
    public String getPostedOn() {
        return postedOn;
    }

    public CommentViewModel setPostedOn(String postedOn) {
        this.postedOn = postedOn;
        return this;
    }
}
