package com.youcode.dtos.response;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CompetitionResponseDTO(
        @NotNull Long id,
        @NotBlank String name,
        @NotBlank String location,
        @NotNull @Future LocalDate startDate,
        @NotNull @Future LocalDate endDate
) {}
