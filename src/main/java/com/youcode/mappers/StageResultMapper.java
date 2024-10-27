package com.youcode.mappers;

import com.youcode.dtos.request.StageResultRequestDTO;
import com.youcode.dtos.response.StageResultResponseDTO;
import com.youcode.entities.StageResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StageResultMapper extends GenericMapper<StageResult,StageResultRequestDTO,StageResultResponseDTO> {

}
