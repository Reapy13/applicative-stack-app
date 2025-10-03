package com.adn.asa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.asa.entity.Team;
import com.adn.asa.service.TeamService;

@RestController
@RequestMapping("team")
public class TeamController {

    private final TeamService service;

    @Autowired
    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping("/most-popular")
    public ResponseEntity<Team> getMostPopularTeam() {
        return ResponseEntity.ok(service.getMostPopularTeam());
    }
    
}
