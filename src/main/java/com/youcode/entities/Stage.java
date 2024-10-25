package com.youcode.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stages")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Stage extends BaseEntity {

    @Positive
    @Column(nullable = false)
    private int number;
    @NotBlank
    private String startLocation;
    @NotBlank
    private String endLocation;
    @Future
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    private Competition competition;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StageResult> stageResults = new ArrayList<>();
}
