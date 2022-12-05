package com.example.ownwebsite.models.service;

import java.time.Instant;

public class ArticleServiceModel {

    private String title;
    private String homeTeam;
    private String awayTeam;
    private Integer scoreHomeTeam;
    private Integer scoreAwayTeam;
    private String description;
    private Instant createdOn;
    private String username;

    public ArticleServiceModel() {
    }


    public String getTitle() {
        return title;
    }

    public ArticleServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public ArticleServiceModel setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public ArticleServiceModel setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    public Integer getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    public ArticleServiceModel setScoreHomeTeam(Integer scoreHomeTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
        return this;
    }

    public Integer getScoreAwayTeam() {
        return scoreAwayTeam;
    }

    public ArticleServiceModel setScoreAwayTeam(Integer scoreAwayTeam) {
        this.scoreAwayTeam = scoreAwayTeam;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArticleServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public ArticleServiceModel setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ArticleServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }
}
