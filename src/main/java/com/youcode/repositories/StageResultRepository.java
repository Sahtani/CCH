package com.youcode.repositories;

import com.youcode.embedded.StageResultId;
import com.youcode.entities.StageResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StageResultRepository extends JpaRepository<StageResult, StageResultId> {
    @Modifying
    @Query("DELETE FROM StageResult sr WHERE sr.stage.id = :stageId AND sr.cyclist.id = :cyclistId")
    void deleteByStageAndCyclist(@Param("stageId") Long stageId, @Param("cyclistId") Long cyclistId);

}
