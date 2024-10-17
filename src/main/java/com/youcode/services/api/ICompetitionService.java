package com.youcode.services.api;

import com.youcode.entities.Competition;
import com.youcode.entities.Cyclist;

import java.util.List;

public interface ICompetitionService {
    List<Competition> getAll();

    Competition getById(Long id);

    Cyclist saveCyclist(Cyclist cyclist);

    void deleteCyclist(Long id);
}
