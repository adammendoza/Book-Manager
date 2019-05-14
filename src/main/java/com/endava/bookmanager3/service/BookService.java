package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Book;
import com.endava.bookmanager3.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService implements IBookService {

    private final IBookRepository bookRepository;

    @Autowired
    public BookService(IBookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {

        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {

        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
    }

    public Book addBook(Book bookToAdd) {

        return bookRepository.save(bookToAdd);
    }

    public Book updateBook(Long id, Book modifiedBook) {

        Book bookToUpdate = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        bookToUpdate.setTitle(modifiedBook.getTitle());
        bookToUpdate.setDescription(modifiedBook.getDescription());
        bookToUpdate.setImage(modifiedBook.getImage());
        bookToUpdate.setISBN(modifiedBook.getISBN());
        bookToUpdate.setAuthor(modifiedBook.getAuthor());
        bookToUpdate.setAwards(modifiedBook.getAwards());
        bookToUpdate.setGenres(modifiedBook.getGenres());
        return bookRepository.save(bookToUpdate);
    }

    public void deleteBookById(Long id) {

        Book bookToDelete = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        bookRepository.delete(bookToDelete);
    }
}
