package com.youcode.entities;

import com.youcode.embedded.GeneralResultId;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Duration;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "general_results")
@Accessors(chain = true)
public class GeneralResult {

    @EmbeddedId
    private GeneralResultId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("competitionId")
    private Competition competition;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cyclistId")
    private Cyclist cyclist;
    @Column(name = "general_time")
    private Duration generalTime;
    @Column(name = "general_rank")
    private Integer generalRank;

}
