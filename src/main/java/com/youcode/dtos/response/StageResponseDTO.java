package com.youcode.dtos.response;

import java.time.LocalDate;

public record StageResponseDTO(Long id,
                               int number,
                               String startLocation,
                               String endLocation,
                               LocalDate date,
                               String type,
                               Long competitionId) {
}
