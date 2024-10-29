package com.youcode.dtos.embeddable;

import java.time.Duration;

public record EmbeddableStageResult(
        EmbeddableCyclist cyclist,
        Integer position,
        Duration duration
) {
}