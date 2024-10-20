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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GeneralResultServiceImpl implements GeneralResultService {
    @Autowired
    private GeneralResultRepository generalResultRepository;
    @Autowired
    private CompetitionRepository competitionRepository;
    @Autowired
    private CyclistRepository cyclistRepository;
    private final GeneralResultMapper generalResultMapper;

    public GeneralResultServiceImpl(GeneralResultMapper generalResultMapper) {
        this.generalResultMapper = generalResultMapper;
    }

    @Override
    public GeneralResultResponseDTO subscribeToCompetition(GeneralResultRequestDTO dto) {
        Cyclist cyclist = cyclistRepository.findById(dto.cyclistId())
                .orElseThrow(() -> new IllegalArgumentException("Cyclist not found with ID: " + dto.cyclistId()));

        Competition competition = competitionRepository.findById(dto.competitionId())
                .orElseThrow(() -> new IllegalArgumentException("Competition not found with ID: " + dto.competitionId()));

        GeneralResult result = new GeneralResult();
        result.setCyclist(cyclist);
        result.setCompetition(competition);
        generalResultRepository.save(result);

        return generalResultMapper.toResponseDTO(result);
    }

}

