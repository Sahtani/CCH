package com.youcode.mappers;

import com.youcode.dtos.request.CompetitionRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDto;
import com.youcode.entities.Competition;
import org.springframework.stereotype.Component;

@Component
public class CompetitionMapper {
    // Convert entity to DTO
    public CompetitionResponseDto toDto(Competition competition) {
        return new CompetitionResponseDto(
                competition.getId(),
                competition.getName(),
                competition.getLocation(),
                competition.getYear(),
                competition.getStartDate(),
                competition.getEndDate()
        );
    }
    // Convert DTO into entity
    public Competition toEntity(CompetitionRequestDTO dto) {
        Competition competition = new Competition();
        competition.setId((long) dto.id());
        competition.setName(dto.name());
        competition.setLocation(dto.location());
        competition.setYear(dto.year());
        competition.setStartDate(dto.startDate());
        competition.setEndDate(dto.endDate());
        return competition;
    }
}
