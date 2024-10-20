package com.youcode.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CyclistRequestDTO(
        @NotBlank String name,
        @NotNull Integer age,
        @NotBlank String nationality,
        @NotNull Long teamId) {

}
