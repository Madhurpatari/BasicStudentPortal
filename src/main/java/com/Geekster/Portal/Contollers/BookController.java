package com.Geekster.Portal.Contollers;

import com.Geekster.Portal.Models.Book;
import com.Geekster.Portal.Models.Course;
import com.Geekster.Portal.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book updateBook) {
        return bookService.updateBook(id,updateBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id) {
        return bookService.deleteBookById(id);
    }
}
