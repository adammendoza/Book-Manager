package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.model.Genre;
import com.endava.bookmanager3.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {

        this.genreService = genreService;
    }


    @GetMapping
    public List<Genre> getGenres() {

        return genreService.getGenres();
    }


    @GetMapping("/{genreId}")
    public Genre getGenre(@PathVariable Long genreId) {

        return genreService.getGenreById(genreId);
    }


    @PostMapping
    public Genre createGenre(@Valid @RequestBody Genre genre) {

        return genreService.addGenre(genre);
    }

    @PutMapping("/{genreId}")
    public Genre updateGenre(@PathVariable Long genreId, @Valid @RequestBody Genre genreDetails) {

        return genreService.updateGenre(genreId, genreDetails);
    }


    @DeleteMapping("/{genreId}")
    public ResponseEntity<?> deleteGenre(@PathVariable Long genreId) {
        genreService.deleteGenreById(genreId);
        return ResponseEntity.ok().build();
    }
}
