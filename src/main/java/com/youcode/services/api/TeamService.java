package com.youcode.services.api;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.entities.Team;
import org.springframework.stereotype.Service;


public interface TeamService extends GenericService<Team,Long, TeamRequestDTO, TeamResponseDTO> {


}
