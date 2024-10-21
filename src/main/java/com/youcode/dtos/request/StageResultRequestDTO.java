package com.youcode.dtos.request;

import java.time.Duration;

public record StageResultRequestDTO(
        Long cyclistId,
        Long stageId,
        Integer rank,
        Duration duration
) {}
