package com.youcode.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cyclists")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist extends BaseEntity {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    @Positive
    private Integer age;

    @NotBlank
    @Column(name = "nationality")
    private String nationality;

    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "cyclist",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StageResult> stageResults = new ArrayList<>();

    @OneToMany(mappedBy = "cyclist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GeneralResult> generalResults = new ArrayList<>();
}
