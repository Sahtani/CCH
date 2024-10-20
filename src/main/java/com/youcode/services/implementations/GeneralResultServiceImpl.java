package com.youcode.services.implementations;

import com.youcode.entities.Competition;
import com.youcode.entities.Cyclist;
import com.youcode.entities.GeneralResult;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.repositories.CyclistRepository;
import com.youcode.repositories.GeneralResultRepository;
import com.youcode.services.api.GeneralResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GeneralResultServiceImpl implements GeneralResultService {
    @Autowired
    private GeneralResultRepository generalResultRepository;
    @Autowired
    private CompetitionRepository competitionRepository;
    @Autowired
    private CyclistRepository cyclistRepository;

    @Override
    public List<GeneralResult> getAll() {
        return List.of();
    }

    @Override
    public Object getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public GeneralResult save(Long competitionId, Long cyclistId) {
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new IllegalArgumentException("Competition not found."));

        Cyclist cyclist = cyclistRepository.findById(cyclistId)
                .orElseThrow(() -> new IllegalArgumentException("Cyclist not found."));

        GeneralResult result = new GeneralResult();
        result.setCyclist(cyclist);
        result.setCompetition(competition);
        generalResultRepository.save(result);
        return result;
    }

    @Override
    public void delete(Long aLong) {

    }
    @Override
    public GeneralResult save(GeneralResult generalResult) {
        return null;
    }
}
