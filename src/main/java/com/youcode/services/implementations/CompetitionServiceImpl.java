package com.youcode.services.implementations;

import com.youcode.dtos.request.CompetitionRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDto;
import com.youcode.entities.Competition;
import com.youcode.mappers.CompetitionMapper;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.services.api.CompetitionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Validated
@Transactional
public class CompetitionServiceImpl implements CompetitionService {

    private CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository,CompetitionMapper competitionMapper) {
        this.competitionRepository = competitionRepository;
        this.competitionMapper = competitionMapper;
    }

    @Override
    public List<CompetitionResponseDto> getAll() {
        return competitionRepository.findAll().stream().map(competitionMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public Optional<CompetitionResponseDto> getById(Long id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Competition not found."));
        return Optional.ofNullable(competitionMapper.toDto(competition));
    }
    @Override
    public CompetitionResponseDto save(CompetitionRequestDTO dto) {
        Competition competition = competitionMapper.toEntity(dto);
        Competition savedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDto(savedCompetition);
    }

    @Override
    public void delete(Long id) {
        competitionRepository.deleteById(id);
    }
    public CompetitionResponseDto update(Competition competition) {
        if (!competitionRepository.existsById(competition.getId())) {
            throw new IllegalArgumentException("Competition not found.");
        }

        Competition updatedCompetition = competitionRepository.save(competition);

        return new CompetitionResponseDto(
                updatedCompetition.getId(),
                updatedCompetition.getName(),
                updatedCompetition.getLocation(),
                updatedCompetition.getYear(),
                updatedCompetition.getStartDate(),
                updatedCompetition.getEndDate()
        );
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
