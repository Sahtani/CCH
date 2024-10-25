package com.youcode.dtos.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.Duration;

public record StageResultResponseDTO(
        @NotNull Long cyclistId,
        @NotNull Long stageId,
        @NotNull @Positive Integer rank,
        @NotNull Duration duration
) {}
