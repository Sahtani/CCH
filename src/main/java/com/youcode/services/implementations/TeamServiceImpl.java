package com.youcode.services.implementations;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.entities.Team;
import com.youcode.mappers.TeamMapper;
import com.youcode.repositories.TeamRepository;
import com.youcode.services.api.TeamService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public List<TeamResponseDTO> getAll() {
        return teamRepository.findAll().stream().map(teamMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional getById(Long id) {
        return Optional.ofNullable(teamRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);

    }
    @Override
    public TeamResponseDTO save(TeamRequestDTO dto) {
        if (dto.getClass().getName() == null || dto.getClass().getName().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty.");
        }
        if (teamRepository.existsByName(dto.getClass().getName())) {
            throw new IllegalArgumentException("Team with the same name already exists.");
        }
        return teamRepository.save(dto.getClass());
    }

}
