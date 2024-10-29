package com.youcode.dtos.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.Duration;

public record StageResultResponseDTO(
        @NotNull StageResponseDTO stage,
        @NotNull CyclistResponseDTO cyclist,
        @NotNull @Positive Integer rank,
        @NotNull Duration duration
) {}
