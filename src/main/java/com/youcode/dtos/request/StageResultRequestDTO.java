package com.youcode.dtos.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.Duration;

public record StageResultRequestDTO(
        @NotNull
        @Positive
        Long cyclistId,

        @NotNull
        @Positive
        Long stageId,

        @NotNull
        @Positive
        Integer rank,

        @NotNull
        Duration duration
) {}
