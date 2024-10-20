package com.youcode.dtos.response;

import java.time.LocalDate;

public record CompetitionResponseDto(
        Long id,
        String name,
        String location,
        Integer year,
        LocalDate startDate,
        LocalDate endDate
) {}
