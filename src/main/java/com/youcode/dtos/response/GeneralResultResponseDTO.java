package com.youcode.dtos.response;

import jakarta.validation.constraints.NotNull;
import java.time.Duration;

public record GeneralResultResponseDTO(
        @NotNull CompetitionResponseDto competition,
        @NotNull CyclistResponseDTO cyclist,
        @NotNull Duration generalTime,
        @NotNull Integer generalRank
) {}
