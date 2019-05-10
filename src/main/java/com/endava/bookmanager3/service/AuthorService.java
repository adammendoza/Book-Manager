package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.AppException;
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
        return authorRepository.getOne(id);
    }

    public void addAuthor(Author authorToAdd) {
        authorRepository.save(authorToAdd);
    }

    public void updateAuthor(Author modifiedAuthor) {

        Author authorToUpdate = authorRepository.getOne(modifiedAuthor.getId());

        if (authorToUpdate == null) {
            throw new AppException("Author to update not found!");
        }

        authorToUpdate.setName(modifiedAuthor.getName());
        authorToUpdate.setEmail(modifiedAuthor.getEmail());
        authorRepository.save(authorToUpdate);
    }

    public void deleteAuthorById(Long id) {

        Author authorToDelete = authorRepository.getOne(id);

        if (authorToDelete == null)
            throw new AppException("Author to delete not found!");

        authorRepository.delete(authorToDelete);
    }
}