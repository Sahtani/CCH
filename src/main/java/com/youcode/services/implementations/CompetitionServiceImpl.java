package com.youcode.services.implementations;

import com.youcode.entities.Competition;
import com.youcode.entities.Cyclist;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.services.api.CompetitionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CompetitionServiceImpl implements CompetitionService {
    private CompetitionRepository competitionRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<Competition> getAll() {
        return competitionRepository.findAll();
    }

    @Override
    public Optional<Competition> getById(Long id) {
        return Optional.ofNullable(competitionRepository.findById(id).orElse(null));
    }

    @Override
    public Competition save(Competition entity) {
        return competitionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        competitionRepository.deleteById(id);
    }
    public Competition update(Competition competition) {

        if (!competitionRepository.existsById(competition.getId())) {
            throw new IllegalArgumentException("Competition not found.");
        }
        return competitionRepository.save(competition);
    }
    @Override
    public List<Competition> getCompetitionsFiltered(LocalDate date, String location) {
        List<Competition> filteredCompetitions = new ArrayList<>(competitionRepository.findAll());

        if (date != null) {
            filteredCompetitions = filteredCompetitions.stream()
                    .filter(comp -> comp.getStartDate().isEqual(date))
                    .collect(Collectors.toList());
        }

        if (location != null && !location.isEmpty()) {
            filteredCompetitions = filteredCompetitions.stream()
                    .filter(comp -> comp.getLocation().equalsIgnoreCase(location))
                    .collect(Collectors.toList());
        }

        return filteredCompetitions;
    }


}
