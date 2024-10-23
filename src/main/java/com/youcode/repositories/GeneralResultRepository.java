package com.youcode.repositories;

import com.youcode.embedded.GeneralResultId;
import com.youcode.entities.GeneralResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralResultRepository extends JpaRepository<GeneralResult, GeneralResultId> {
}
