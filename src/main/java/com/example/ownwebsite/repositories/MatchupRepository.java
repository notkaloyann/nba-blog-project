package com.example.ownwebsite.repositories;

import com.example.ownwebsite.models.entities.Matchup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchupRepository extends JpaRepository<Matchup, Long> {
}
