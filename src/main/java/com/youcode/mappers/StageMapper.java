package com.youcode.mappers;

import com.youcode.dtos.request.StageRequestDTO;
import com.youcode.dtos.response.StageResponseDTO;
import com.youcode.entities.Stage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StageMapper extends GenericMapper<Stage, StageRequestDTO, StageResponseDTO> {

}
