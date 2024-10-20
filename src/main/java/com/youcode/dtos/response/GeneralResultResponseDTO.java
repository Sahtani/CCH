package com.youcode.dtos.response;

import jakarta.validation.constraints.NotNull;

public record GeneralResultResponseDTO(
         CompetitionResponseDto competition,
         CyclistResponseDTO cyclist) {
}
