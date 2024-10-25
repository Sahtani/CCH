package com.youcode.mappers;

import com.youcode.dtos.request.GeneralResultRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.dtos.response.GeneralResultResponseDTO;
import com.youcode.entities.GeneralResult;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Mapper(componentModel = "spring")
public interface GeneralResultMapper extends GenericMapper<GeneralResult, GeneralResultRequestDTO, GeneralResultResponseDTO>  {

// private final CompetitionMapper competitionMapper;
// private final CyclistMapper cyclistMapper;
// private final CompetitionRepository competitionRepository;
// private final CyclistRepository cyclistRepository;
//
//    public GeneralResultMapper(CompetitionMapper competitionMapper, CyclistMapper cyclistMapper, CompetitionRepository competitionRepository, CyclistRepository cyclistRepository) {
//        this.competitionMapper = competitionMapper;
//        this.cyclistMapper = cyclistMapper;
//        this.competitionRepository = competitionRepository;
//        this.cyclistRepository = cyclistRepository;
//    }
//
//    // Map properties from entity to DTO
//    public GeneralResultResponseDTO toResponseDTO(GeneralResult entity) {
//        CompetitionResponseDto competitionDTO = competitionMapper.toResponseDTO(entity.getCompetition());
//        CyclistResponseDTO cyclistDTO = cyclistMapper.toDTO(entity.getCyclist());
//
//        Duration generalTime = entity.getGeneralTime();
//        Integer generalRank = entity.getGeneralRank();
//
//        return new GeneralResultResponseDTO(competitionDTO, cyclistDTO, generalTime, generalRank);
//    }
//
//
//
//    // Map properties from DTO to entity
//    public GeneralResult toEntity(GeneralResultRequestDTO dto) {
//        // Retrieve Cyclist and Competition entities from the repositories
//        Cyclist cyclist = cyclistRepository.findById(dto.cyclistId())
//                .orElseThrow(() -> new IllegalArgumentException("Cyclist not found with ID: " + dto.cyclistId()));
//        Competition competition = competitionRepository.findById(dto.competitionId())
//                .orElseThrow(() -> new IllegalArgumentException("Competition not found with ID: " + dto.competitionId()));
//
//        // Create the composite ID
//        GeneralResultId resultId = new GeneralResultId();
//        resultId.setCyclistId(cyclist.getId());
//        resultId.setCompetitionId(competition.getId());
//
//        // Create and set the GeneralResult
//        GeneralResult generalResult = new GeneralResult();
//        generalResult.setId(resultId);  //set the composist id
//        generalResult.setCyclist(cyclist);
//        generalResult.setCompetition(competition);
//
//        return generalResult;
//    }

}
