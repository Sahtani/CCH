package com.youcode.dtos.response;

import java.time.Duration;

public record StageResultResponseDTO(
        Long cyclistId,
        Long stageId,
        Integer rank,
        Duration duration
) {}
