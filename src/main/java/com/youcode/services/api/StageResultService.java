package com.youcode.services.api;

import com.youcode.dtos.request.StageResultRequestDTO;
import com.youcode.dtos.response.StageResultResponseDTO;

import java.util.List;
import java.util.Optional;

public interface StageResultService {
    List<StageResultResponseDTO> getAll();
    Optional<StageResultResponseDTO> findByStageIdAndCyclistId(Long stageId, Long cyclistId);
    StageResultResponseDTO save(StageResultRequestDTO stageResultRequestDTO);
    void delete(Long stageId, Long cyclistId);
}
