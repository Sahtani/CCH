package com.youcode.services.api;

import com.youcode.dtos.request.StageRequestDTO;
import com.youcode.dtos.response.StageResponseDTO;
import com.youcode.entities.Stage;

public interface StageService extends GenericService<Stage, Long, StageRequestDTO, StageResponseDTO>  {
}
