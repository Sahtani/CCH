package com.youcode.dtos.embeddable;

import java.time.Duration;

public record EmbeddableGeneralResult(
        EmbeddableCyclist cyclist,
        Duration totalTime,
        Long position
) {
}
