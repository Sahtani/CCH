package com.youcode.mappers;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.entities.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper extends GenericMapper<Team, TeamRequestDTO, TeamResponseDTO> {


}
