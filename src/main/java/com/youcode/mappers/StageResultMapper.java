package com.youcode.mappers;

import com.youcode.dtos.request.StageResultRequestDTO;
import com.youcode.dtos.response.StageResultResponseDTO;
import com.youcode.entities.StageResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StageResultMapper extends GenericMapper<StageResult,StageResultRequestDTO,StageResultResponseDTO> {

//    public StageResultResponseDTO toResponseDTO(StageResult stageResult) {
//        return new StageResultResponseDTO(
//                stageResult.getCyclist().getId(),
//                stageResult.getStage().getId(),
//                stageResult.getRank(),
//                stageResult.getDuration()
//        );
//    }
//
//    public static StageResult toEntity(StageResultRequestDTO dto) {
//        StageResult stageResult = new StageResult();
//        stageResult.setRank(dto.rank());
//        stageResult.setDuration(dto.duration());
//        return stageResult;
//    }
}
