package com.example.ownwebsite.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team extends BaseEntity{

    private TeamEnum teamName;
    private Integer wins;
    private Integer losses;

    public Team() {
    }

    @Enumerated(EnumType.STRING)
    public TeamEnum getTeamName() {
        return teamName;
    }

    public Team setTeamName(TeamEnum teamName) {
        this.teamName = teamName;
        return this;
    }


    @Column(name = "team_wins")
    public Integer getWins() {
        return wins;
    }

    public Team setWins(Integer wins) {
        this.wins = wins;
        return this;
    }

    @Column(name = "team_losses")
    public Integer getLosses() {
        return losses;
    }

    public Team setLosses(Integer losses) {
        this.losses = losses;
        return this;
    }
}
