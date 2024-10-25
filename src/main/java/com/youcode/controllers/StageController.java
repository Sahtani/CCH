package com.youcode.controllers;

import com.youcode.dtos.request.StageRequestDTO;
import com.youcode.dtos.response.StageResponseDTO;
import com.youcode.services.api.StageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stages")
@RequiredArgsConstructor
public class StageController {


    private final StageService stageService;

    @GetMapping
    public List<StageResponseDTO> getAllStages() {
        return stageService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageResponseDTO> getStageById(@PathVariable Long id) {
        return stageService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StageResponseDTO createStage(@RequestBody StageRequestDTO stageRequest) {
        return stageService.save(stageRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StageResponseDTO> updateStage(@PathVariable Long id, @RequestBody StageRequestDTO stageRequest) {
        return ResponseEntity.ok(stageService.update(id, stageRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long id) {
        stageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
