package com.youcode.controllers;

import com.youcode.dtos.request.CompetitionRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDto;
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
    public ResponseEntity<List<CompetitionResponseDto>> getAllCompetitions() {
        List<CompetitionResponseDto> competitions = competitionService.getAll();
        return ResponseEntity.ok(competitions);
    }

    // GET competition by ID
    @GetMapping("/{id}")
    public ResponseEntity<CompetitionResponseDto> getCompetitionById(@PathVariable Long id) {
        return competitionService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // POST create new competition
    @PostMapping
    public ResponseEntity<CompetitionResponseDto> createCompetition(@RequestBody @Valid CompetitionRequestDTO competitionRequestDTO) {
        CompetitionResponseDto createdCompetition = competitionService.save(competitionRequestDTO);
        return new ResponseEntity<>(createdCompetition, HttpStatus.CREATED);
    }

    // PUT update competition by ID
    @PutMapping("/{id}")
    public ResponseEntity<CompetitionResponseDto> update(@PathVariable Long id, @RequestBody @Valid CompetitionRequestDTO dto) {
        CompetitionResponseDto competition = competitionService.update(id, dto);
        return ResponseEntity.ok(competition);
    }

    // DELETE competition by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        competitionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
