package com.youcode.controllers;

import com.youcode.dtos.request.CompetitionRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDTO;
import com.youcode.services.api.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competitions")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;

    // GET all competitions
    @GetMapping
    public ResponseEntity<List<CompetitionResponseDTO>> getAllCompetitions() {
        List<CompetitionResponseDTO> competitions = competitionService.getAll();
        return ResponseEntity.ok(competitions);
    }

    // GET competition by ID
    @GetMapping("/{id}")
    public ResponseEntity<CompetitionResponseDTO> getCompetitionById(@PathVariable Long id) {
        return competitionService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Return 404 without body
    }

    // POST create new competition
    @PostMapping
    public ResponseEntity<CompetitionResponseDTO> createCompetition(@RequestBody @Valid CompetitionRequestDTO competitionRequestDTO) {
        CompetitionResponseDTO createdCompetition = competitionService.save(competitionRequestDTO);
        return new ResponseEntity<>(createdCompetition, HttpStatus.CREATED);
    }

    // PUT update competition by ID
    @PutMapping("/{id}")
    public ResponseEntity<CompetitionResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CompetitionRequestDTO dto) {
        return competitionService.getById(id) // Check if competition exists
                .map(existingCompetition -> {
                    CompetitionResponseDTO updatedCompetition = competitionService.update(id, dto);
                    return ResponseEntity.ok(updatedCompetition);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Return 404 if not found
    }

    // DELETE competition by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (competitionService.getById(id).isPresent()) { // Check if competition exists before deleting
            competitionService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if not found
        }
    }
}
