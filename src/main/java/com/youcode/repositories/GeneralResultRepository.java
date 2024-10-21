package com.youcode.repositories;

import com.youcode.embedded.GeneralResultId;
import com.youcode.entities.GeneralResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralResultRepository extends JpaRepository<GeneralResult, GeneralResultId> {
}
