package com.youcode.dtos.response;

public record CyclistResponseDTO(
        Long id,
        String name,
        int age,
        String nationality,
        Long teamId) {
}
