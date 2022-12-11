package com.example.ownwebsite.models.binding;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CommentAddBindingModel {

    private String commentContent;

    public CommentAddBindingModel() {
    }

    @NotNull
    @Length(min = 5)
    public String getCommentContent() {
        return commentContent;
    }

    public CommentAddBindingModel setCommentContent(String commentContent) {
        this.commentContent = commentContent;
        return this;
    }
}
