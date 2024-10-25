package com.youcode.services.implementations;

import com.youcode.common.exceptions.EntityNotFoundException;
import com.youcode.dtos.request.StageRequestDTO;
import com.youcode.dtos.response.StageResponseDTO;
import com.youcode.mappers.StageMapper;
import com.youcode.repositories.StageRepositroy;
import com.youcode.services.api.StageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class StageServiceImpl implements StageService {

    private final StageRepositroy stageRepo;
    private final StageMapper stageMapper;
    @Override
    public List<StageResponseDTO> getAll() {
        return stageRepo.findAll()
                .stream().map(stageMapper::toDto)
                .toList();
    }

    @Override
    public Optional<StageResponseDTO> getById(Long id) {
        return Optional.ofNullable(stageRepo.findById(id)
                .map(stageMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Stage", id)));
    }
    @Override
    public StageResponseDTO save(StageRequestDTO stageRequestDTO) {
        return null;
    }

    @Override
    public StageResponseDTO update(Long id, StageRequestDTO stageRequestDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
