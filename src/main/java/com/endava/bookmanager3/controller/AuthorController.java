package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.model.Author;
import com.endava.bookmanager3.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {

        this.authorService = authorService;
    }


    @GetMapping
    public List<Author> getAuthors() {

        return authorService.getAuthors();
    }


    @GetMapping("/{authorId}")
    public Author getAuthor(@PathVariable Long authorId) {

        return authorService.getAuthorById(authorId);
    }


    @PostMapping
    public Author createAuthor(@Valid @RequestBody Author author) {

        return authorService.addAuthor(author);
    }


    @PutMapping("/{authorId}")
    public Author updateAuthor(@PathVariable Long authorId, @Valid @RequestBody Author authorDetails) {

        return authorService.updateAuthor(authorId, authorDetails);
    }


    @DeleteMapping("/{authorId}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthorById(authorId);
        return ResponseEntity.ok().build();
    }
}
