package com.endava.bookmanager3.repository;

import com.endava.bookmanager3.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository  extends JpaRepository<Genre, Long> {
}
