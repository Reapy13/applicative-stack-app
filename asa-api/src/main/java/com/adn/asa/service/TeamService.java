package com.adn.asa.service;

import java.util.List;

import com.adn.asa.entity.Team;

public interface TeamService {
    
    Team getMostPopularTeam();

    List<Team> getAllTeams();
}
