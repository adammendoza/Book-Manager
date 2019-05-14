package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Genre;
import com.endava.bookmanager3.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final IGenreRepository genreRepository;

    @Autowired
    public GenreService(IGenreRepository genreRepository) {

        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenres() {

        return genreRepository.findAll();
    }

    public Genre getGenreById(Long id) {

        return genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id));
    }

    public Genre addGenre(Genre genreToAdd) {

        return genreRepository.save(genreToAdd);
    }

    public Genre updateGenre(Long id, Genre modifiedGenre) {

        Genre genreToUpdate = genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id));
        genreToUpdate.setName(modifiedGenre.getName());
        genreToUpdate.setDescription(modifiedGenre.getDescription());
        return genreRepository.save(genreToUpdate);
    }

    public void deleteGenreById(Long id) {

        Genre genreToDelete = genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id));
        genreRepository.delete(genreToDelete);
    }
}
