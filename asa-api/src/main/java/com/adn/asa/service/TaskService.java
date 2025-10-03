package com.adn.asa.service;

import java.util.List;

import com.adn.asa.entity.Task;

public interface TaskService {
    
    List<Task> getAllTasks(Long workerId);
}
