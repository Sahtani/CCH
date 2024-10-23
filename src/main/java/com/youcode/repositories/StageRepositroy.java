package com.youcode.repositories;

import com.youcode.entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepositroy extends JpaRepository<Stage, Long> {
}
