package com.youcode.services.implementations;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.entities.Team;
import com.youcode.mappers.CyclistMapper;
import com.youcode.mappers.TeamMapper;
import com.youcode.repositories.TeamRepository;
import com.youcode.services.api.TeamService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Validated
@Transactional
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final CyclistMapper cyclistMapper;

    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper, CyclistMapper cyclistMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
        this.cyclistMapper = cyclistMapper;
    }

    @Override
    public List<TeamResponseDTO> getAll() {
        return null;

    }


    @Override
    public Optional<TeamResponseDTO> getById(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("Team not found."));

        Set<CyclistResponseDTO> cyclistDTOs = team.getCyclists()
                .stream()
                .map(cyclistMapper::toDto)
                .collect(Collectors.toSet());

        return Optional.of(new TeamResponseDTO(team.getId(), team.getName(), cyclistDTOs));
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);

    }
    @Override
    public TeamResponseDTO save(TeamRequestDTO dto) {
        if (dto.name() == null || dto.name().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty.");
        }
        if (teamRepository.existsByName(dto.name())) {
            throw new IllegalArgumentException("Team with the same name already exists.");
        }
        Team team = new Team();
        team.setName(dto.name());
        Team savedTeam = teamRepository.save(team);
        return new TeamResponseDTO(savedTeam.getId(), savedTeam.getName(), null);
    }


}
