package com.youcode.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {

    @NotBlank
    private Integer year;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    @OneToMany(mappedBy = "competition", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Stage> stages = new ArrayList<>();

    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GeneralResult> generalResults;
}
