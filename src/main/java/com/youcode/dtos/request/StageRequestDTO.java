package com.youcode.dtos.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record StageRequestDTO(@Positive int number,
                              @NotBlank String startLocation,
                              @NotBlank String endLocation,
                              @Future LocalDate date,
                              @NotBlank String type,
                              Long competitionId) {
}
