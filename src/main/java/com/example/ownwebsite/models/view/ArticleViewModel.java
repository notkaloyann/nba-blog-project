package com.example.ownwebsite.models.view;

import java.time.Instant;

public class ArticleViewModel {

    private String title;
    private String description;
    private Instant createdOn;
    private String userEntity;

    public ArticleViewModel() {
    }

    public String getTitle() {
        return title;
    }

    public ArticleViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArticleViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public ArticleViewModel setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getUserEntity() {
        return userEntity;
    }

    public ArticleViewModel setUserEntity(String userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
