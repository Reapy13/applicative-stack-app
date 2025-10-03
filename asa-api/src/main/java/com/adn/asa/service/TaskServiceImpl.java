package com.adn.asa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.asa.entity.Task;
import com.adn.asa.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getAllTasks(Long workerId) {

        return workerId != null ? repository.findAllByWorkerId(workerId) : repository.findAll();
    }
    
}
