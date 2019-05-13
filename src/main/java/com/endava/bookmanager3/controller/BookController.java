package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Book;
import com.endava.bookmanager3.service.BookService;
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
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {

        this.bookService = bookService;
    }


    @GetMapping(MappingNames.BOOKS)
    public String getBooks(Model model) {

        List<Book> books = bookService.getBooks();
        model.addAttribute(AttributeNames.BOOKS, books);
        return ViewNames.BOOKS;
    }


    @GetMapping(MappingNames.VIEW_BOOK)
    public String getBook(@RequestParam Long id, Model model) {

        Book book = bookService.getBookById(id);

        if (book == null) {
            throw new ResourceNotFoundException("Book", "id", id);
        }

        model.addAttribute(AttributeNames.BOOK, book);
        return ViewNames.VIEW_BOOK;
    }


    @GetMapping(MappingNames.ADD_BOOK)
    public String addEditBook(@RequestParam(required = false, defaultValue = "-1") Long id, Model model) {

        Book book = bookService.getBookById(id);

        if (book == null) {
                book = new Book();
        }

        model.addAttribute(AttributeNames.BOOK, book);
        return ViewNames.ADD_BOOK;
    }


    @PostMapping(MappingNames.ADD_BOOK)
    public String processBook(@Valid @ModelAttribute(AttributeNames.BOOK) Book book) {

        if (book.getId() == null) {
            bookService.addBook(book);
        } else {
            bookService.updateBook(book);
        }

        return "redirect:/" + MappingNames.BOOKS;
    }


    @DeleteMapping(MappingNames.DELETE_BOOK)
    public String deleteBook(@RequestParam Long id) {
        bookService.deleteBookById(id);
        return "redirect:/" + MappingNames.BOOKS;
    }
}
