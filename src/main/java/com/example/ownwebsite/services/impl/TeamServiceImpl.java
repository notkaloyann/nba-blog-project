package com.example.ownwebsite.services.impl;

import com.example.ownwebsite.models.entities.Team;
import com.example.ownwebsite.models.entities.TeamEnum;
import com.example.ownwebsite.repositories.TeamRepository;
import com.example.ownwebsite.services.TeamService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Optional<Team> returnTeamByName(String teamName) {

        return Optional.ofNullable(this.teamRepository.getTeamByTeamName(TeamEnum.valueOf(teamName)));
    }

    @Override
    public void seedTeams() {
        if (this.teamRepository.count() == 0) {
            for (TeamEnum teamEnum : TeamEnum.values()) {
                this.teamRepository.save(new Team().setTeamName(teamEnum).setWins(0).setLosses(0));
            }

        }
        
    }
}
