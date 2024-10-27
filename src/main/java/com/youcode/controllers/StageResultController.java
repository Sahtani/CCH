package com.youcode.controllers;

import com.youcode.dtos.request.StageResultRequestDTO;
import com.youcode.dtos.response.StageResultResponseDTO;
import com.youcode.services.api.StageResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stage-results")
@RequiredArgsConstructor
public class StageResultController {
    private final StageResultService service;

    @GetMapping
    public ResponseEntity<List<StageResultResponseDTO>> findAll() {
        List<StageResultResponseDTO> result = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{stageId}/{cyclistId}")
    public ResponseEntity<StageResultResponseDTO> findByStageIdAndCyclistId(@PathVariable Long stageId, @PathVariable Long cyclistId) {
        return service.findByStageIdAndCyclistId(stageId, cyclistId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StageResultResponseDTO> save(@RequestBody @Valid StageResultRequestDTO dto) {
        StageResultResponseDTO result = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{stageId}/{cyclistId}")
    public ResponseEntity<Void> deleteByStageIdAndCyclistId(@PathVariable Long stageId, @PathVariable Long cyclistId) {
        service.delete(stageId, cyclistId);
        return ResponseEntity.noContent().build();
    }
}
