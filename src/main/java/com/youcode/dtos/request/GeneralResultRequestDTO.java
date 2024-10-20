package com.youcode.dtos.request;

import jakarta.validation.constraints.NotNull;

public record GeneralResultRequestDTO(@NotNull Long competitionId, @NotNull Long cyclistId) {
}
