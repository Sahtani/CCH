package com.youcode.controllers;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.services.api.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    //GET all teams
    @GetMapping
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams() {
        List<TeamResponseDTO> teams = teamService.getAll();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    //Get a team by id
    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable Long id) {
        Optional<TeamResponseDTO> team = teamService.getById(id);
        return ResponseEntity.ok(team.get());
    }

    //POST a add new team
    @PostMapping
    public ResponseEntity<TeamResponseDTO> createTeam(@RequestBody TeamRequestDTO teamRequestDTO) {
        TeamResponseDTO createdTeam = teamService.save(teamRequestDTO);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    //PUT to update an existing team
    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> updateTeam(@PathVariable Long id, @RequestBody TeamRequestDTO teamRequestDTO) {

        TeamResponseDTO updatedTeam;
        if (teamService.getById(id).isPresent()) {
            updatedTeam = teamService.update(id, teamRequestDTO);
            return new ResponseEntity<>(updatedTeam, HttpStatus.OK);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable("id") Long id) {
        Optional<TeamResponseDTO> team = teamService.getById(id);

        if (team.isPresent()) {
            teamService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Team with ID " + id + " has been deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Team with ID " + id + " not found.");
        }
    }

}
