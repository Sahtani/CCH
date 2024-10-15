package com.youcode.entities;


import com.youcode.embedded.StageResultId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Entity
@Table(name = "stage_results")

@Getter
@Setter
@NoArgsConstructor
public class StageResult {

    @EmbeddedId
    private StageResultId id;

    @NotNull
    @Positive
    private Integer position;

    @NotNull
    private Duration duration;

    @MapsId("cyclistId")
    @ManyToOne
    private Cyclist cyclist;

    @MapsId("stageId")
    @ManyToOne
    private Stage stage;
}
