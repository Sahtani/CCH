package com.youcode.repositories;

import com.youcode.entities.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist,Long>  {
  //  boolean existsByName(String fullName);
}
