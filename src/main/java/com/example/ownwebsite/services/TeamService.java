package com.example.ownwebsite.services;


import com.example.ownwebsite.models.entities.Team;

public interface TeamService {

    Team returnTeamByName(String teamName);
    void seedTeams();

}
