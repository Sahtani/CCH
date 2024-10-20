package com.youcode.services.api;

import com.youcode.dtos.request.GeneralResultRequestDTO;
import com.youcode.dtos.response.GeneralResultResponseDTO;
import com.youcode.entities.GeneralResult;

public interface GeneralResultService  {
  SubscribeToCompetitionResponseDto subscribeToCompetition(SubscribeToCompetitionRequestDto dto);
}
