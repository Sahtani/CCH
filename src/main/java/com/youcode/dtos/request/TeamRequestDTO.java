package com.youcode.dtos.request;

import jakarta.validation.constraints.NotNull;

public record TeamRequestDTO(@NotNull String name) {
}
