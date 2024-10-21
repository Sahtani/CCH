package com.youcode.mappers;

import com.youcode.dtos.request.GeneralResultRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDto;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.dtos.response.GeneralResultResponseDTO;
import com.youcode.embedded.GeneralResultId;
import com.youcode.entities.Competition;
import com.youcode.entities.Cyclist;
import com.youcode.entities.GeneralResult;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.repositories.CyclistRepository;
import org.springframework.stereotype.Component;

@Component
public class GeneralResultMapper {
 private final CompetitionMapper competitionMapper;
 private final CyclistMapper cyclistMapper;
 private final CompetitionRepository competitionRepository;
 private final CyclistRepository cyclistRepository;

    public GeneralResultMapper(CompetitionMapper competitionMapper, CyclistMapper cyclistMapper, CompetitionRepository competitionRepository, CyclistRepository cyclistRepository) {
        this.competitionMapper = competitionMapper;
        this.cyclistMapper = cyclistMapper;
        this.competitionRepository = competitionRepository;
        this.cyclistRepository = cyclistRepository;
    }

    // Map properties from entity to DTO
    public GeneralResultResponseDTO toResponseDTO(GeneralResult entity) {
        CompetitionResponseDto competitionDTO = competitionMapper.toResponseDTO(entity.getCompetition());
        CyclistResponseDTO cyclistDTO = cyclistMapper.toResponseDTO(entity.getCyclist());

        return new GeneralResultResponseDTO(competitionDTO, cyclistDTO);
    }


    // Map properties from DTO to entity
    public GeneralResult toEntity(GeneralResultRequestDTO dto) {
        // Retrieve Cyclist and Competition entities from the repositories
        Cyclist cyclist = cyclistRepository.findById(dto.cyclistId())
                .orElseThrow(() -> new IllegalArgumentException("Cyclist not found with ID: " + dto.cyclistId()));
        Competition competition = competitionRepository.findById(dto.competitionId())
                .orElseThrow(() -> new IllegalArgumentException("Competition not found with ID: " + dto.competitionId()));

        // Create the composite ID
        GeneralResultId resultId = new GeneralResultId();
        resultId.setCyclistId(cyclist.getId());
        resultId.setCompetitionId(competition.getId());

        // Create and set the GeneralResult
        GeneralResult generalResult = new GeneralResult();
        generalResult.setId(resultId);  // Set the composite ID
        generalResult.setCyclist(cyclist);
        generalResult.setCompetition(competition);

        return generalResult;
    }

}
