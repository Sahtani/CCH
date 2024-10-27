package com.youcode.controllers;

import com.youcode.dtos.request.GeneralResultRequestDTO;
import com.youcode.dtos.response.GeneralResultResponseDTO;
import com.youcode.services.api.GeneralResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/general-results")
@RequiredArgsConstructor
public class GeneralResultController {

    private final GeneralResultService service;

    @GetMapping
    public ResponseEntity<List<GeneralResultResponseDTO>> getAllGeneralResults() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{competitionId}/{cyclistId}")
    public ResponseEntity<GeneralResultResponseDTO> getById(
            @PathVariable Long competitionId,
            @PathVariable Long cyclistId) {
        GeneralResultResponseDTO result = service.findByCompetitionIdAndCyclistId(competitionId, cyclistId);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<GeneralResultResponseDTO> create(@RequestBody @Valid GeneralResultRequestDTO dto) {
        GeneralResultResponseDTO created = service.subscribeToCompetition(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("/{competitionId}/{cyclistId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long competitionId,
            @PathVariable Long cyclistId) {
        service.delete(competitionId, cyclistId);
        return ResponseEntity.noContent().build();
    }
}
