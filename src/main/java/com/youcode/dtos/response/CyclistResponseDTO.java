package com.youcode.dtos.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CyclistResponseDTO(
        @NotNull Long id,
        @NotBlank String name,
        @NotNull @Positive int age,
        @NotNull String nationality,
        @NotNull Long teamId) {
}
