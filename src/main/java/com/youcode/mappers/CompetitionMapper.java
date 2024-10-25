package com.youcode.mappers;

import com.youcode.dtos.request.CompetitionRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDto;
import com.youcode.entities.Competition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetitionMapper extends GenericMapper<Competition, CompetitionRequestDTO, CompetitionResponseDto> {

}
