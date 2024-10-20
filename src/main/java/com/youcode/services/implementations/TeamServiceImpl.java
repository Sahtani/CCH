package com.youcode.services.implementations;

import com.youcode.entities.Team;
import com.youcode.repositories.TeamRepository;
import com.youcode.services.api.TeamService;

import java.util.List;
import java.util.Optional;

public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Override
    public Object getById(Long id) {
        return Optional.ofNullable(teamRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);

    }
    @Override
    public Team save(Team team) {
        if (team.getName() == null || team.getName().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty.");
        }
        if (teamRepository.existsByName(team.getName())) {
            throw new IllegalArgumentException("Team with the same name already exists.");
        }
        return teamRepository.save(team);
    }

}
