package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Author;
import com.endava.bookmanager3.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final IAuthorRepository authorRepository;

    @Autowired
    public AuthorService(IAuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {

        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {

        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
    }

    public Author addAuthor(Author authorToAdd) {

        return authorRepository.save(authorToAdd);
    }

    public Author updateAuthor(Long id, Author modifiedAuthor) {

        Author authorToUpdate = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorToUpdate.setName(modifiedAuthor.getName());
        authorToUpdate.setEmail(modifiedAuthor.getEmail());
        authorToUpdate.setDescription(modifiedAuthor.getDescription());
        return authorRepository.save(authorToUpdate);
    }

    public void deleteAuthorById(Long id) {

        Author authorToDelete = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRepository.delete(authorToDelete);
    }
}
