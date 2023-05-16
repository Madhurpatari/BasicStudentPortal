package com.Geekster.Portal.Services;

import com.Geekster.Portal.Models.Book;
import com.Geekster.Portal.Models.Student;
import com.Geekster.Portal.Repositories.IBookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(String id, Book updateBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            book.setAuthor(updateBook.getAuthor());
            book.setTitle(updateBook.getTitle());
            book.setDescription(updateBook.getDescription());
            book.setPrice(updateBook.getPrice());
            book.setBookId(updateBook.getBookId());
            book.setStudent(updateBook.getStudent());
            return bookRepository.save(book);
        }else{
            throw new EntityNotFoundException("Book with id : "+id+" not found");
        }
    }

    public ResponseEntity<String> deleteBookById(String id) {
        boolean isBookPresent = bookRepository.existsById(id);
        if(isBookPresent){
            bookRepository.deleteById(id);
            return new ResponseEntity<>("Book details deleted successfully..Thank you!!",
                    HttpStatus.NO_CONTENT);
        }else{
            throw new EntityNotFoundException("Book with id : "+id+" not found");
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
