package com.youcode.dtos.embeddable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmbeddableCyclist(
        @NotNull Long id,
        @NotBlank String name,
        @NotNull Integer age,
        @NotBlank String nationality) {
}
