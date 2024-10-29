package com.youcode.dtos.response;

import com.youcode.dtos.embeddable.EmbeddableCyclist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TeamResponseDTO(@NotNull Long id,
                              @NotBlank String name,
                              List<EmbeddableCyclist> cyclists) {
}
