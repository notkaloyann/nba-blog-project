package com.example.ownwebsite.models.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ArticleAddBindingModel {

    private String title;
    private String homeTeam;
    private String awayTeam;
    private Integer scoreHomeTeam;
    private Integer scoreAwayTeam;
    private String description;

    public ArticleAddBindingModel() {
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public ArticleAddBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    @NotNull
    public String getHomeTeam() {
        return homeTeam;
    }

    public ArticleAddBindingModel setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }
    @NotNull
    public String getAwayTeam() {
        return awayTeam;
    }

    public ArticleAddBindingModel setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    public Integer getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    public ArticleAddBindingModel setScoreHomeTeam(Integer scoreHomeTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
        return this;
    }

    public Integer getScoreAwayTeam() {
        return scoreAwayTeam;
    }

    public ArticleAddBindingModel setScoreAwayTeam(Integer scoreAwayTeam) {
        this.scoreAwayTeam = scoreAwayTeam;
        return this;
    }

    @NotNull
    @Length(min = 20)
    public String getDescription() {
        return description;
    }

    public ArticleAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
