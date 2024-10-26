package com.youcode.entities;


import com.youcode.embedded.StageResultId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Duration;

@Entity
@Table(name = "stage_results")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class StageResult {

    @EmbeddedId
    private StageResultId id;

    @NotNull
    @Positive
    private Integer rank;

    @NotNull
    private Duration duration;

    @MapsId("cyclistId")
    @ManyToOne
    private Cyclist cyclist;

    @MapsId("stageId")
    @ManyToOne
    private Stage stage;

    public StageResult(Cyclist cyclist, Stage stage, Duration duration) {

    }
}
