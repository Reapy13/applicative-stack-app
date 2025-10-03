package com.adn.asa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.asa.entity.Team;
import com.adn.asa.entity.Worker;
import com.adn.asa.repository.TeamRepository;

import jakarta.transaction.Transactional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;

    @Autowired
    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    /**
     * Return the most popular Team.
     * 
     * The team popular score is calculated by :
     * - The sum of the worker's popular of the team
     * - Multiplied by the team coefficient
     * 
     * @return The most popular team
     */
    @Transactional
    @Override
    public Team getMostPopularTeam() {
        List<Team> teams = repository.findAll();
        return teams.stream()
                .sorted((t1, t2) -> (t2.getWorkers().stream().mapToInt(Worker::getPopularity).sum()
                        * t2.getCoefficient())
                        - (t1.getWorkers().stream().mapToInt(Worker::getPopularity).sum() * t1.getCoefficient()))
                .toList().getFirst();

    }

    @Override
    public List<Team> getAllTeams() {
        return repository.findAll();
    }

}
