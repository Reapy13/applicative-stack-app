package com.adn.asa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adn.asa.entity.Worker;
import com.adn.asa.service.WorkerService;

@RestController
@RequestMapping("worker")
public class WorkerController {

    private final WorkerService service;

    @Autowired
    public WorkerController(WorkerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers(@RequestParam(required = false) Long teamId) {
        return ResponseEntity.ok(service.getAllWorkers(teamId));
    }
    
}