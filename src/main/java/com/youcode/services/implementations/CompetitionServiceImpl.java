package com.youcode.services.implementations;

import com.youcode.entities.Competition;
import com.youcode.services.api.CompetitionService;

import java.util.List;
import java.util.Optional;

public class CompetitionServiceImpl implements CompetitionService {
    @Override
    public List<Competition> getAll() {
        return List.of();
    }

    @Override
    public Optional<Competition> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Competition save(Competition entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
