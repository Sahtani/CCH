package com.youcode.mappers;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.entities.Team;
import com.youcode.entities.Cyclist;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TeamMapper {

    public Team toEntity(TeamRequestDTO dto) {
        Team team = new Team();
        team.setName(dto.name());
        return team;
    }

    public TeamResponseDTO toDto(Team team) {
        Set<CyclistResponseDTO> cyclists = team.getCyclists().stream()
                .map(cyclist -> new CyclistResponseDTO(
                        cyclist.getId(),
                        cyclist.getName(),
                        cyclist.getAge(),
                        cyclist.getNationality(),
                        cyclist.getTeam().getId()
                ))
                .collect(Collectors.toSet());

        return new TeamResponseDTO(team.getId(), team.getName(), cyclists);
    }
}
