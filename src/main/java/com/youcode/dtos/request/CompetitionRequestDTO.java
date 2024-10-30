package com.youcode.dtos.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
public record CompetitionRequestDTO(
        @NotBlank String name,
        @NotBlank String location,
        @NotNull @Future LocalDate startDate,
        @NotNull @Future LocalDate endDate
) {}
