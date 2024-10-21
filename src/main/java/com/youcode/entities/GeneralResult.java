package com.youcode.entities;

import com.youcode.embedded.GeneralResultId;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "general_results")
public class GeneralResult {

    @EmbeddedId
    private GeneralResultId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("competitionId")
    private Competition competition;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cyclistId")
    private Cyclist cyclist;

    private Duration generalTime;
    private Integer generalRank;

}
