package com.youcode.mappers;

import com.youcode.dtos.request.CompetitionRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDto;
import com.youcode.entities.Competition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetitionMapper extends GenericMapper<Competition, CompetitionRequestDTO, CompetitionResponseDto> {

    // Convert entity to DTO
//    public CompetitionResponseDto toResponseDTO(Competition competition) {
//        return new CompetitionResponseDto(
//                competition.getId(),
//                competition.getName(),
//                competition.getLocation(),
//                competition.getYear(),
//                competition.getStartDate(),
//                competition.getEndDate()
//        );
//    }
//    // Convert DTO into entity
//    public Competition toEntity(CompetitionRequestDTO dto) {
//        Competition competition = new Competition();
//        competition.setName(dto.name());
//        competition.setLocation(dto.location());
//        competition.setYear(dto.year());
//        competition.setStartDate(dto.startDate());
//        competition.setEndDate(dto.endDate());
//        return competition;
//    }
}
