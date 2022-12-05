package com.example.ownwebsite.models.entities;


import javax.persistence.*;

@Entity
@Table(name = "matchup")
public class Matchup extends BaseEntity{

    private Team homeTeam;
    private Team awayTeam;
    private Integer scoreHomeTeam;
    private Integer scoreAwayTeam;

    public Matchup() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Team getHomeTeam() {
        return homeTeam;
    }

    public Matchup setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public Team getAwayTeam() {
        return awayTeam;
    }

    public Matchup setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    @Column(name = "home_team_score",nullable = false)
    public Integer getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    public Matchup setScoreHomeTeam(Integer scoreHomeTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
        return this;
    }

    @Column(name = "away_team_score",nullable = false)
    public Integer getScoreAwayTeam() {
        return scoreAwayTeam;
    }

    public Matchup setScoreAwayTeam(Integer scoreAwayTeam) {
        this.scoreAwayTeam = scoreAwayTeam;
        return this;
    }
}
