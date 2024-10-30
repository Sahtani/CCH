package com.youcode.repositories;

import com.youcode.embedded.GeneralResultId;
import com.youcode.entities.GeneralResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralResultRepository extends JpaRepository<GeneralResult, GeneralResultId> {

    @Modifying
    @Query("DELETE FROM GeneralResult e WHERE e.competition.id = :competitionId AND e.cyclist.id = :cyclistId")
    void deleteByCompetitionIdAndCyclistId(@Param("competitionId") Long competitionId, @Param("cyclistId") Long cyclistId);
}
