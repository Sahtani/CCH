package com.youcode.services.implementations;

import com.youcode.common.exceptions.CyclistNotSubscribeCompetitionException;
import com.youcode.common.exceptions.EntityNotFoundException;
import com.youcode.common.exceptions.StageClosedException;
import com.youcode.dtos.request.StageResultRequestDTO;
import com.youcode.dtos.response.StageResultResponseDTO;
import com.youcode.embedded.StageResultId;
import com.youcode.entities.Cyclist;
import com.youcode.entities.GeneralResult;
import com.youcode.entities.Stage;
import com.youcode.entities.StageResult;
import com.youcode.mappers.StageResultMapper;
import com.youcode.repositories.CyclistRepository;
import com.youcode.repositories.StageRepositroy;
import com.youcode.repositories.StageResultRepository;
import com.youcode.services.api.StageResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StageResultServiceImpl implements StageResultService {

    private final StageResultRepository stageResultRepository;
    private final CyclistRepository cyclistRepository;
    private final StageRepositroy stageRepository;
    private final StageResultMapper stageResultMapper;

    @Override
    public List<StageResultResponseDTO> getAll() {
        return stageResultRepository.findAll()
                .stream().map(stageResultMapper::toDto)
                .toList();
    }

    @Override
    public Optional<StageResultResponseDTO> findByStageIdAndCyclistId(Long stageId, Long cyclistId) {
        StageResultId stageResultId = new StageResultId(stageId, cyclistId);
        return Optional.ofNullable(stageResultRepository.findById(stageResultId)
                .map(stageResultMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("stage result", stageResultId)));
    }

    @Override
    public StageResultResponseDTO save(StageResultRequestDTO stageResultRequestDTO) {
        Cyclist cyclist = cyclistRepository.findById(stageResultRequestDTO.cyclistId())
                .orElseThrow(() -> new EntityNotFoundException("Cyclist", stageResultRequestDTO.cyclistId()));

        Stage stage = stageRepository.findById(stageResultRequestDTO.stageId())
                .orElseThrow(() -> new EntityNotFoundException("Stage", stageResultRequestDTO.stageId()));

        if (!isCyclistJoinedCompetition(cyclist, stage)) {
            throw new CyclistNotSubscribeCompetitionException( "The cyclist is not subscribed to this competition.");
        }
        StageResult savedResult = stageResultRepository.save(
                new StageResult(cyclist, stage, stageResultRequestDTO.duration())
        );
        return stageResultMapper.toDto(savedResult);
    }

    @Override
    public void delete(Long stageId, Long cyclistId) {

    }
    private boolean isCyclistJoinedCompetition(Cyclist cyclist, Stage stage) {
        return cyclist.getGeneralResults().stream()
                .map(GeneralResult::getCompetition)
                .anyMatch(competition -> stage.getCompetition().getId().equals(competition.getId()));
    }
}
