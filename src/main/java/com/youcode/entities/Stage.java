package com.youcode.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stages")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stage extends BaseEntity {

    @Positive
    @Column(nullable = false)
    private int number;
    @NotBlank
    @Column(name = "start_location", nullable = false)
    private String startLocation;
    @NotBlank
    @Column(name = "end_location", nullable = false)
    private String endLocation;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StageResult> stageResults = new ArrayList<>();
}
