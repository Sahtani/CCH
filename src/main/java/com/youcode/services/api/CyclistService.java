package com.youcode.services.api;

import com.youcode.dtos.request.CyclistRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.entities.Cyclist;

public interface CyclistService extends GenericService<Cyclist, Long, CyclistRequestDTO, CyclistResponseDTO> {

}
