package com.youcode.controllers;

import com.youcode.dtos.request.CyclistRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.services.api.CyclistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cyclists")
@RequiredArgsConstructor
public class CyclistController {

    private final CyclistService cyclistService;

    // GET all cyclists
    @GetMapping
    public ResponseEntity<List<CyclistResponseDTO>> getAllCyclists() {
        List<CyclistResponseDTO> cyclists = cyclistService.getAll();
        return new ResponseEntity<>(cyclists, HttpStatus.OK);
    }

    // GET a cyclist by ID
    @GetMapping("/{id}")
    public ResponseEntity<CyclistResponseDTO> getCyclistById(@PathVariable Long id) {
        Optional<CyclistResponseDTO> cyclistOpt = cyclistService.getById(id);

        if (cyclistOpt.isPresent()) {
            return ResponseEntity.ok(cyclistOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // POST a new cyclist
    @PostMapping
    public ResponseEntity<CyclistResponseDTO> createCyclist(@RequestBody CyclistRequestDTO cyclistRequestDTO) {
        CyclistResponseDTO createdCyclist = cyclistService.save(cyclistRequestDTO);
        return new ResponseEntity<>(createdCyclist, HttpStatus.CREATED);
    }

    // PUT to update an existing cyclist
    @PutMapping("/{id}")
    public ResponseEntity<CyclistResponseDTO> updateCyclist(@PathVariable Long id, @RequestBody CyclistRequestDTO cyclistRequestDTO) {
        if (cyclistService.getById(id).isPresent()) {
            CyclistResponseDTO updatedCyclist = cyclistService.update(id, cyclistRequestDTO);
            return new ResponseEntity<>(updatedCyclist, HttpStatus.OK);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    // DELETE a cyclist
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCyclist(@PathVariable Long id) {
        Optional<CyclistResponseDTO> cyclist = cyclistService.getById(id);
        if (cyclist.isPresent()) {
            cyclistService.delete(id);
            return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.NO_CONTENT);

        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
