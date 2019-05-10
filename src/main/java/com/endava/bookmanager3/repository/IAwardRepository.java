package com.endava.bookmanager3.repository;

import com.endava.bookmanager3.model.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAwardRepository extends JpaRepository<Award, Long> {
}
