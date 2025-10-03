package com.adn.asa.service;

import java.util.List;

import com.adn.asa.entity.Worker;

public interface WorkerService {
    
    List<Worker> getAllWorkers(Long teamId);
}