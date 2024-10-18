package com.youcode.repositories;

import com.youcode.entities.Competition;
import com.youcode.entities.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition,Long> {

}
