package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Genre;
import com.endava.bookmanager3.service.GenreService;
import com.endava.bookmanager3.util.AttributeNames;
import com.endava.bookmanager3.util.MappingNames;
import com.endava.bookmanager3.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {

        this.genreService = genreService;
    }


    @GetMapping(MappingNames.GENRES)
    public String getGenres(Model model) {

        List<Genre> genres = genreService.getGenres();
        model.addAttribute(AttributeNames.GENRES, genres);
        return ViewNames.GENRES;
    }


    @GetMapping(MappingNames.VIEW_GENRE)
    public String getGenre(@RequestParam Long id, Model model) {

        Genre genre = genreService.getGenreById(id);

        if (genre == null) {
            throw new ResourceNotFoundException("Genre", "id", id);
        }

        model.addAttribute(AttributeNames.GENRE, genre);
        return ViewNames.VIEW_GENRE;
    }


    @GetMapping(MappingNames.ADD_GENRE)
    public String addEditGenre(@RequestParam(required = false, defaultValue = "-1") Long id, Model model) {

        Genre genre = genreService.getGenreById(id);

        if (genre == null) {
            genre = new Genre();
        }

        model.addAttribute(AttributeNames.GENRE, genre);
        return ViewNames.ADD_GENRE;
    }


    @PostMapping(MappingNames.ADD_GENRE)
    public String processGenre(@Valid @ModelAttribute(AttributeNames.GENRE) Genre genre) {

        if (genre.getId() == null) {
            genreService.addGenre(genre);
        } else {
            genreService.updateGenre(genre);
        }

        return "redirect:/" + MappingNames.GENRES;
    }


    @GetMapping(MappingNames.DELETE_GENRE)
    public String deleteGenre(@RequestParam Long id) {
        genreService.deleteGenreById(id);
        return "redirect:/" + MappingNames.GENRES;
    }
}
