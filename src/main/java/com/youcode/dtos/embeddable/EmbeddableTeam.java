package com.youcode.dtos.embeddable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EmbeddableTeam(@NotNull UUID id,
                             @NotBlank String name) {
}