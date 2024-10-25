package com.youcode.services.api;

import com.youcode.dtos.request.CompetitionRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDTO;
import com.youcode.dtos.response.CompetitionResponseDto;
import com.youcode.entities.Competition;

import java.time.LocalDate;
import java.util.List;

public interface CompetitionService extends GenericService<Competition,Long, CompetitionRequestDTO, CompetitionResponseDTO> {
    List<Competition> getCompetitionsFiltered(LocalDate date, String location);
}
