package com.youcode.dtos.embeddable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record EmbeddableStage(@NotNull Long id,
                              @NotNull @Positive Integer number,
                              @NotBlank String startLocation,
                              @NotBlank String endLocation,
                              @NotNull LocalDate date
) {
}