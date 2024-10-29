package com.youcode.dtos.response;

import com.youcode.dtos.embeddable.EmbeddableGeneralResult;
import com.youcode.dtos.embeddable.EmbeddableStage;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CompetitionResponseDTO(
        @NotNull Long id,
        @NotBlank String name,
        @NotBlank String location,
        @NotNull @Future LocalDate startDate,
        @NotNull @Future LocalDate endDate,
        @NotNull Boolean closed,
        @NotNull List<EmbeddableStage> stages,
        @NotNull List<EmbeddableGeneralResult> generalResults
) {}
