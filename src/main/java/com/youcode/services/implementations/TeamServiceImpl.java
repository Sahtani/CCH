package com.youcode.services.implementations;

import com.youcode.entities.Team;
import com.youcode.repositories.CyclistRepository;
import com.youcode.repositories.TeamRepository;
import com.youcode.services.api.TeamService;

import java.util.List;
import java.util.Optional;

public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAll() {
        return List.of();
    }

    @Override
    public Optional<Team> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Team save(Team entity) {
       return teamRepository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }
}
