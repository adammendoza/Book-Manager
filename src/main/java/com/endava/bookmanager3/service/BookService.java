package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.AppException;
import com.endava.bookmanager3.model.Award;
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

        return bookRepository.getOne(id);
    }

    public void addBook(Book bookToAdd) {

        bookRepository.save(bookToAdd);
    }

    public void updateAward(Book modifiedBook) {

        Book bookToUpdate = bookRepository.getOne(modifiedBook.getId());

        if (bookToUpdate == null) {
            throw new AppException("Book to update not found!");
        }

        bookToUpdate.setTitle(modifiedBook.getTitle());
        bookToUpdate.setDescription(modifiedBook.getDescription());
        bookToUpdate.setImage(modifiedBook.getImage());
        bookToUpdate.setISBN(modifiedBook.getISBN());
        //bookToUpdate.setAuthor(modifiedBook.getAuthor());
        //bookToUpdate.setAwards(modifiedBook.getAwards());
        //bookToUpdate.setGenres(modifiedBook.getGenres());
        bookRepository.save(bookToUpdate);
    }

    public void deleteBookById(Long id) {

        Book bookToDelete = bookRepository.getOne(id);

        if (bookToDelete == null)
            throw new AppException("Book to delete not found!");

        bookRepository.delete(bookToDelete);
    }
}
