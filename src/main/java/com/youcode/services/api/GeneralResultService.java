package com.youcode.services.api;

import com.youcode.dtos.request.GeneralResultRequestDTO;
import com.youcode.dtos.response.GeneralResultResponseDTO;

import java.util.List;

public interface GeneralResultService  {
  List<GeneralResultResponseDTO> findAll();

  GeneralResultResponseDTO findByCompetitionIdAndCyclistId(Long competitionId, Long cyclistId);

  GeneralResultResponseDTO subscribeToCompetition(GeneralResultRequestDTO dto);

  void delete(Long competitionId, Long cyclistId);
}
