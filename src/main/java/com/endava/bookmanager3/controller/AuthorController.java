package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Author;
import com.endava.bookmanager3.service.AuthorService;
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
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {

        this.authorService = authorService;
    }


    @GetMapping(MappingNames.AUTHORS)
    public String getAuthors(Model model) {

        List<Author> authors = authorService.getAuthors();
        model.addAttribute(AttributeNames.AUTHORS, authors);
        return ViewNames.AUTHORS;
    }


    @GetMapping(MappingNames.VIEW_AUTHOR)
    public String getAuthor(@RequestParam Long id, Model model) {

        Author author = authorService.getAuthorById(id);

        if (author == null) {
            throw new ResourceNotFoundException("Author", "id", id);
        }

        model.addAttribute(AttributeNames.AUTHOR, author);
        return ViewNames.VIEW_AUTHOR;
    }


    @GetMapping(MappingNames.ADD_AUTHOR)
    public String addEditAuthor(@RequestParam(required = false, defaultValue = "-1") Long id, Model model) {

        Author author = authorService.getAuthorById(id);

        if (author == null) {
                author = new Author();
        }

        model.addAttribute(AttributeNames.AUTHOR, author);
        return ViewNames.ADD_AUTHOR;
    }


    @PostMapping(MappingNames.ADD_AUTHOR)
    public String processAuthor(@Valid @ModelAttribute(AttributeNames.AUTHOR) Author author) {

        if (author.getId() == 0) {
            authorService.addAuthor(author);
        } else {
            authorService.updateAuthor(author);
        }

        return "redirect:/" + MappingNames.AUTHORS;
    }


    @DeleteMapping(MappingNames.DELETE_AUTHOR)
    public String deleteAuthor(@RequestParam Long id) {
        authorService.deleteAuthorById(id);
        return "redirect:/" + MappingNames.AUTHORS;
    }
}
