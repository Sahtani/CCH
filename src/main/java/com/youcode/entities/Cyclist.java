package com.youcode.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cyclists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Column(name = "dateBirth")
    private LocalDate dateBirth;
    @NotNull
    @Column(name = "nationality")
    private String nationality;
    @NotBlank
    @Column(name = "team")
    private String team;

    @ManyToMany(mappedBy = "cyclists")
    private Set<Competition> competitions = new HashSet<>();

    @OneToMany(mappedBy = "cyclists")
    private List<StageResult> stageResults;
}
