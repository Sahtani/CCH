package com.youcode.dtos.response;

public record GeneralResultResponseDTO(
        Long id,
        Long competitionId,
        Long cyclistId,
        String cyclistName,
        String competitionName) {
}
