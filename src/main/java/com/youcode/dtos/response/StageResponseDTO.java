package com.youcode.dtos.response;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record StageResponseDTO(
        @NotNull Long id,
        @Positive int number,
        @NotBlank String startLocation,
        @NotBlank String endLocation,
        @NotNull @Future LocalDate date,
        @NotBlank String type,
        @NotNull Long competitionId
) {}
