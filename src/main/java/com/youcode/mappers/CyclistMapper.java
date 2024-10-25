package com.youcode.mappers;

import com.youcode.dtos.request.CyclistRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.entities.Cyclist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CyclistMapper extends GenericMapper<Cyclist, CyclistRequestDTO, CyclistResponseDTO> {

}