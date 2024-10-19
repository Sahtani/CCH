package com.youcode.dtos;

import java.time.LocalDate;
import java.util.List;

public class CompetitionDTO {
    private Long id;
    private String name;
    private String location;
    private Integer year;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> stageNames;
}
