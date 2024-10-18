package com.youcode.config;

import com.youcode.repositories.TeamRepository;
import com.youcode.services.api.TeamService;
import com.youcode.services.implementations.TeamServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public TeamService teamService(TeamRepository teamRepository) {
        return new TeamServiceImpl(teamRepository);
    }
}
