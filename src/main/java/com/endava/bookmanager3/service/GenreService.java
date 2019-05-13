package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.AppException;
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

        return genreRepository.findById(id).orElse(null);
    }

    public void addGenre(Genre genreToAdd) {

        genreRepository.save(genreToAdd);
    }

    public void updateGenre(Genre modifiedGenre) {

        Genre genreToUpdate = genreRepository.findById(modifiedGenre.getId()).orElse(null);

        if (genreToUpdate == null) {
            throw new AppException("Genre to update not found!");
        }

        genreToUpdate.setName(modifiedGenre.getName());
        genreToUpdate.setDescription(modifiedGenre.getDescription());
        genreRepository.save(genreToUpdate);
    }

    public void deleteGenreById(Long id) {

        Genre genreToDelete = genreRepository.findById(id).orElse(null);

        if (genreToDelete == null)
            throw new AppException("Genre to delete not found!");

        genreRepository.delete(genreToDelete);
    }
}
