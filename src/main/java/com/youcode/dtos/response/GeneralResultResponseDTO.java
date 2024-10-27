package com.youcode.dtos.response;

import jakarta.validation.constraints.NotNull;
import java.time.Duration;

public record GeneralResultResponseDTO(
        @NotNull CompetitionResponseDTO competition,
        @NotNull CyclistResponseDTO cyclist
) {}
