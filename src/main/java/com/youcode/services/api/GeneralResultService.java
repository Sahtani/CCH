package com.youcode.services.api;

import com.youcode.entities.GeneralResult;

public interface GeneralResultService extends GenericService<GeneralResult,Long> {
  GeneralResult  save(Long competitionId, Long cyclistId);
}
