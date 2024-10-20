package com.youcode.dtos.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter

public record CompetitionRequestDTO(
        int id,
        @NotBlank String name,
        @NotNull String location,
        @Min(1900) @Max(2100) Integer year,
        @NotNull @Future LocalDate startDate,
        @NotNull @Future LocalDate endDate
) {}
