package com.youcode.mappers;

import com.youcode.dtos.request.GeneralResultRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.dtos.response.GeneralResultResponseDTO;
import com.youcode.entities.GeneralResult;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Mapper(componentModel = "spring")
public interface GeneralResultMapper extends GenericMapper<GeneralResult, GeneralResultRequestDTO, GeneralResultResponseDTO>  {
}
