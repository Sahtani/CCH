package com.youcode.controllers;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.entities.Team;
import com.youcode.services.api.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams() {
        List<TeamResponseDTO> teams = teamService.getAll();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable Long id) {
        Optional<TeamResponseDTO> team = teamService.getById(id);
        return ResponseEntity.ok(team.get());
    }
    @PostMapping
    public ResponseEntity<TeamResponseDTO> createTeam(@RequestBody TeamRequestDTO teamRequestDTO) {
        TeamResponseDTO createdTeam = teamService.save(teamRequestDTO);
        return ResponseEntity.ok(createdTeam);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> updateTeam(@PathVariable Long id, @RequestBody TeamRequestDTO teamRequestDTO) {
        TeamResponseDTO updatedTeam = teamService.update(id,teamRequestDTO);
        return ResponseEntity.ok(updatedTeam);
    }
}
