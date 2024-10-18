package com.youcode.services.implementations;

import com.youcode.entities.Team;
import com.youcode.repositories.CyclistRepository;
import com.youcode.repositories.TeamRepository;
import com.youcode.services.api.TeamService;
import org.springframework.stereotype.Service;

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
    public void delete(Long aLong) {

    }
    @Override
    public Team save(Team team) {
        if (teamRepository.existsByName(team.getName())) {
            throw new IllegalArgumentException("Team with the same name already exists.");
        }
        return teamRepository.save(team);
    }
}
