package com.example.ownwebsite.services.impl;


import com.example.ownwebsite.models.entities.Matchup;
import com.example.ownwebsite.models.service.ArticleServiceModel;
import com.example.ownwebsite.repositories.MatchupRepository;
import com.example.ownwebsite.services.MatchupService;
import com.example.ownwebsite.services.TeamService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MatchupServiceImpl implements MatchupService {

    private final MatchupRepository matchupRepository;
    private final TeamService teamService;


    public MatchupServiceImpl(MatchupRepository matchupRepository, TeamService teamService) {
        this.matchupRepository = matchupRepository;
        this.teamService = teamService;
    }

    @Override
    public Matchup addMatchup(ArticleServiceModel articleServiceModel) {
        Matchup matchup = new Matchup();
        matchup.setHomeTeam(this.teamService.returnTeamByName(articleServiceModel.getHomeTeam()).orElse(null))
                .setAwayTeam(this.teamService.returnTeamByName(articleServiceModel.getAwayTeam()).orElse(null))
                .setScoreHomeTeam(articleServiceModel.getScoreHomeTeam())
                .setScoreAwayTeam(articleServiceModel.getScoreAwayTeam());
        this.matchupRepository.save(matchup);
        return matchup;
    }
}
