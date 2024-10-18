package com.youcode.services.api;

import com.youcode.entities.Competition;

import java.time.LocalDate;
import java.util.List;

public interface CompetitionService extends GenericService<Competition,Long> {
    List<Competition> getCompetitionsFiltered(LocalDate date, String location);
}
