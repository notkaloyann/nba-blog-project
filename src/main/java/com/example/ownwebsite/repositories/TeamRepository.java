package com.example.ownwebsite.repositories;

import com.example.ownwebsite.models.entities.Team;
import com.example.ownwebsite.models.entities.TeamEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> getTeamByTeamName(TeamEnum teamEnum);

}
