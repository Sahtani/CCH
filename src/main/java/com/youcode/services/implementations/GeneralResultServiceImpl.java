package com.youcode.services.implementations;

import com.youcode.common.exceptions.EntityNotFoundException;
import com.youcode.dtos.request.GeneralResultRequestDTO;
import com.youcode.dtos.response.GeneralResultResponseDTO;
import com.youcode.embedded.GeneralResultId;
import com.youcode.entities.Competition;
import com.youcode.entities.Cyclist;
import com.youcode.entities.GeneralResult;
import com.youcode.mappers.GeneralResultMapper;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.repositories.CyclistRepository;
import com.youcode.repositories.GeneralResultRepository;
import com.youcode.services.api.GeneralResultService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class GeneralResultServiceImpl implements GeneralResultService {

    private final GeneralResultRepository generalResultRepository;
    private final CompetitionRepository competitionRepository;
    private final CyclistRepository cyclistRepository;
    private final GeneralResultMapper generalResultMapper;

    @Override
    public List<GeneralResultResponseDTO> findAll() {
        return generalResultRepository.findAll().stream()
                .map(generalResultMapper::toDto).toList();
    }

    @Override
    public GeneralResultResponseDTO findByCompetitionIdAndCyclistId(Long competitionId, Long cyclistId) {
        GeneralResultId generalResultId = new GeneralResultId(cyclistId, competitionId);
        return generalResultRepository.findById(generalResultId)
                .map(generalResultMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "General Result ", generalResultId));
    }

    @Override
    public GeneralResultResponseDTO subscribeToCompetition(GeneralResultRequestDTO dto) {

        Optional<Cyclist> cyclist = Optional.ofNullable(cyclistRepository.findById(dto.cyclistId())
                .orElseThrow(() -> new EntityNotFoundException("cyclist", dto.cyclistId())));
        Optional<Competition> competition = Optional.ofNullable(competitionRepository.findById(dto.competitionId())
                .orElseThrow(() -> new EntityNotFoundException("competition ", dto.competitionId())));


        GeneralResult generalResult = new GeneralResult(competition.get(), cyclist.get());
        GeneralResult savedResult = generalResultRepository.save(generalResult);
        return generalResultMapper.toDto(savedResult);


    }

    @Override
    public void delete(Long competitionId, Long cyclistId) {
        GeneralResultId generalResultId = new GeneralResultId(cyclistId, competitionId);
        if (!generalResultRepository.existsById(generalResultId))
            throw new EntityNotFoundException("General Result " + generalResultId);
        generalResultRepository.deleteByCompetitionIdAndCyclistId(competitionId, cyclistId);
    }


}

