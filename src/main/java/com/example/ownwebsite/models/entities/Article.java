package com.example.ownwebsite.models.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "article")
public class Article extends BaseEntity{

    private String title;
    private Matchup matchup;
    private String description;
    private Instant createdOn;
    private User userEntity;

    @Column(name = "created_on",nullable = false)
    public Instant getCreatedOn() {
        return createdOn;
    }


    public Article setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @ManyToOne
    public User getUserEntity() {
        return userEntity;
    }

    public Article setUserEntity(User userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public Article() {
    }

    @Column(name = "article_name", nullable = false)
    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    @OneToOne
    public Matchup getMatchup() {
        return matchup;
    }

    public Article setMatchup(Matchup matchup) {
        this.matchup = matchup;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Article setDescription(String description) {
        this.description = description;
        return this;
    }
}
