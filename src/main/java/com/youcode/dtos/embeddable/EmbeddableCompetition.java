package com.youcode.dtos.embeddable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmbeddableCompetition(@NotNull Long id,
                                    @NotBlank String name,
                                    @NotNull LocalDate startDate,
                                    @NotNull LocalDate endDate,
                                    @NotNull Boolean closed) {
}
