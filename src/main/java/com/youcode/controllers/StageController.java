package com.youcode.controllers;

import com.youcode.dtos.request.StageRequestDTO;
import com.youcode.dtos.response.StageResponseDTO;
import com.youcode.dtos.response.StageResultResponseDTO;
import com.youcode.entities.Stage;
import com.youcode.mappers.StageResultMapperImpl;
import com.youcode.services.implementations.StageResultServiceImpl;
import com.youcode.services.implementations.StageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stages")
@RequiredArgsConstructor
public class StageController {


    private StageServiceImpl stageService;

    @GetMapping
    public List<StageResultResponseDTO> getAllStages() {
        return stageService.getStageResults();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageResponseDTO> getStageById(@PathVariable Long id) {
        return stageService.getStageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StageResponseDTO createStage(@RequestBody StageRequestDTO stageRequest) {
        return stageService.createStage(stageRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StageResponseDTO> updateStage(@PathVariable Long id, @RequestBody StageRequestDTO stageRequest) {
        return ResponseEntity.ok(stageService.updateStage(id, stageRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
        return ResponseEntity.noContent().build();
    }
}
