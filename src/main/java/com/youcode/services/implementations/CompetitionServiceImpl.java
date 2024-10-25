package com.youcode.services.implementations;

import com.youcode.dtos.request.CompetitionRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDTO;
import com.youcode.entities.Competition;
import com.youcode.mappers.CompetitionMapper;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.services.api.CompetitionService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Validated
@RequiredArgsConstructor
@Transactional
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;

    @Override
    public List<CompetitionResponseDTO> getAll() {
        return competitionRepository.findAll().stream().map(competitionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<CompetitionResponseDTO> getById(Long id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Competition not found."));
        return Optional.ofNullable(competitionMapper.toDto(competition));
    }

    @Override
    public CompetitionResponseDTO save(CompetitionRequestDTO dto) {
        Competition competition = competitionMapper.toEntity(dto);
        Competition savedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDto(savedCompetition);
    }

    @Override
    public CompetitionResponseDTO update(Long id, CompetitionRequestDTO competitionRequestDTO) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Competition with ID " + id + " not found."));

        competition.setName(competitionRequestDTO.name())
                .setLocation(competitionRequestDTO.location())
                .setStartDate(competitionRequestDTO.startDate())
                .setEndDate(competitionRequestDTO.endDate());

        competitionRepository.save(competition);

        return competitionMapper.toDto(competition);
    }

    @Override
    public void delete(Long id) {
        competitionRepository.deleteById(id);
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
