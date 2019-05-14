package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.model.Book;
import com.endava.bookmanager3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {

        this.bookService = bookService;
    }


    @GetMapping
    public List<Book> getBooks() {

        return bookService.getBooks();
    }


    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {

        return bookService.getBookById(bookId);
    }


    @PostMapping
    public Book createBook(@Valid @RequestBody Book book) {

        return bookService.addBook(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable Long bookId, @Valid @RequestBody Book bookDetails) {

        return bookService.updateBook(bookId, bookDetails);
    }


    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.ok().build();
    }
}
