package com.youcode.services.implementations;

import com.youcode.common.exceptions.EntityNotFoundException;
import com.youcode.common.exceptions.ValidationException;
import com.youcode.dtos.request.StageRequestDTO;
import com.youcode.dtos.response.StageResponseDTO;
import com.youcode.entities.Competition;
import com.youcode.entities.Stage;
import com.youcode.mappers.StageMapper;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.repositories.StageRepositroy;
import com.youcode.services.api.StageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class StageServiceImpl implements StageService {

    private final StageRepositroy stageRepo;
    private final StageMapper stageMapper;
    private final CompetitionRepository competitionRepo;
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
        Competition competition = validateCompetitionExists(stageRequestDTO.competitionId());
        LocalDate stageDate = stageRequestDTO.date();
        if (!isDateWithinCompetitionRange(stageDate, competition)) {
            throw new ValidationException("Stage date must be between competition start date and end date.");
        }
        Stage stage = stageMapper.toEntity(stageRequestDTO);
        stage = stageRepo.save(stage);
        return stageMapper.toDto(stage);
    }

    @Override
    public StageResponseDTO update(Long id, StageRequestDTO stageRequestDTO) {
       Stage stage = stageRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Stage", id));
        Competition competition = validateCompetitionExists(stageRequestDTO.competitionId());
    LocalDate stageDate = stageRequestDTO.date();
    if (!isDateWithinCompetitionRange(stageDate, competition)) {
        throw new ValidationException("Stage date must be between competition start date and end date.");
    }
        stage.setNumber(stageRequestDTO.number())
                .set(dto.distance())
                .setStartLocation(dto.startLocation())
                .setEndLocation(dto.endLocation())
                .setDate(dto.date())
                .setCompetition(competition);
        return mapper.toResponseDto(stage);
    }
    @Override
    public void delete(Long aLong) {

    }

    private boolean isDateWithinCompetitionRange(LocalDate stageDate, Competition competition) {
        return !stageDate.isBefore(competition.getStartDate()) && !stageDate.isAfter(competition.getEndDate());

    }
    private Competition validateCompetitionExists(Long competitionId) {
        return competitionRepo.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition" ,competitionId));
    }
}
