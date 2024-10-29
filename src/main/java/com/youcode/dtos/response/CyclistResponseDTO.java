package com.youcode.dtos.response;

import com.youcode.dtos.embeddable.EmbeddableTeam;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CyclistResponseDTO(
        @NotNull Long id,
        @NotBlank String name,
        @NotNull @Positive int age,
        @NotNull String nationality,
        @NotNull EmbeddableTeam team) {
}
