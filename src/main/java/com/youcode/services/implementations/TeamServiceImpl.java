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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@Transactional
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final CyclistMapper cyclistMapper;
    @Override
    public List<TeamResponseDTO> getAll() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }



    @Override
    public Optional<TeamResponseDTO> getById(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("Team not found."));

        List<CyclistResponseDTO> cyclistDTOs = team.getCyclists()
                .stream()
                .map(cyclistMapper::toDto)
                .collect(Collectors.toList());
        return Optional.ofNullable(teamMapper.toDto(team));
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
        return teamMapper.toDto(savedTeam);
    }

    @Override
    public TeamResponseDTO update(Long id, TeamRequestDTO teamDTO) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isEmpty()) {
            throw new RuntimeException("Team with ID " + id + " not found.");
        }
        Team existingTeam = team.get();
        existingTeam.setName(teamDTO.name());
        return teamMapper.toDto(existingTeam);

    }

}
