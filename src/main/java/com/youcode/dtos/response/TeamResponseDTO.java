package com.youcode.dtos.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TeamResponseDTO(@NotNull Long id,
                              @NotBlank String name) {
}
