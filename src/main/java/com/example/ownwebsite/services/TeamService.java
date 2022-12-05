package com.example.ownwebsite.services;


import com.example.ownwebsite.models.entities.Team;

import java.util.Optional;

public interface TeamService {

    Optional<Team> returnTeamByName(String teamName);
    void seedTeams();

}
