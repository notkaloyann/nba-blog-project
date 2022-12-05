package com.example.ownwebsite.repositories;

import com.example.ownwebsite.models.entities.Team;
import com.example.ownwebsite.models.entities.TeamEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team getTeamByTeamName(TeamEnum teamEnum);

}
