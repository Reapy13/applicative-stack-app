package com.adn.asa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.asa.entity.Worker;
import com.adn.asa.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {
    
    private final WorkerRepository repository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Worker> getAllWorkers(Long teamId) {
        return teamId != null ? repository.findAllByTeamId(teamId) : repository.findAll();
    }
}
