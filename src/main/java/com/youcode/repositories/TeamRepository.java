package com.youcode.repositories;

import com.youcode.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsByName(String name);
}
