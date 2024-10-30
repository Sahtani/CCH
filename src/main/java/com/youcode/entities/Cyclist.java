package com.youcode.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cyclists")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Cyclist extends BaseEntity {

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Integer age;

    @NotBlank
    private String nationality;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    @OneToMany(mappedBy = "cyclist",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StageResult> stageResults = new ArrayList<>();

    @OneToMany(mappedBy = "cyclist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GeneralResult> generalResults = new ArrayList<>();
}
