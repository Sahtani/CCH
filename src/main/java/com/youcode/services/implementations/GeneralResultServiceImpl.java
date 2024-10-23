package com.youcode.services.implementations;

import com.youcode.dtos.request.GeneralResultRequestDTO;
import com.youcode.dtos.response.GeneralResultResponseDTO;
import com.youcode.entities.Competition;
import com.youcode.entities.Cyclist;
import com.youcode.entities.GeneralResult;
import com.youcode.mappers.GeneralResultMapper;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.repositories.CyclistRepository;
import com.youcode.repositories.GeneralResultRepository;
import com.youcode.services.api.GeneralResultService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
@Validated
public class GeneralResultServiceImpl implements GeneralResultService {

    private final GeneralResultRepository generalResultRepository;

    private final CompetitionRepository competitionRepository;

    private final CyclistRepository cyclistRepository;
    private final GeneralResultMapper generalResultMapper;

    public GeneralResultServiceImpl(GeneralResultRepository generalResultRepository, CompetitionRepository competitionRepository, CyclistRepository cyclistRepository, GeneralResultMapper generalResultMapper) {
        this.generalResultRepository = generalResultRepository;
        this.competitionRepository = competitionRepository;
        this.cyclistRepository = cyclistRepository;
        this.generalResultMapper = generalResultMapper;
    }

    @Override
    public GeneralResultResponseDTO subscribeToCompetition(GeneralResultRequestDTO dto) {
        // Convert DTO to Entity
        GeneralResult result = generalResultMapper.toEntity(dto);
        System.out.println(result + "hdfkjhf");
        GeneralResult savedResult = generalResultRepository.save(result);
        System.out.println(savedResult.toString());
        if (savedResult == null) {
            throw new RuntimeException("Failed to save GeneralResult.");
        }

        // Convert the saved result to a response DTO
        return generalResultMapper.toDto(savedResult);
    }


}

