package com.youcode.repositories;

import com.youcode.embedded.StageResultId;
import com.youcode.entities.StageResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageResultRepository extends JpaRepository<StageResult, StageResultId> {
}
