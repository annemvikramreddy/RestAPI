package com.example.bookapi.controller;
import java.util.*;

import com.example.bookapi.model.Book;
// import com.example.bookapi.service.BookService;
import com.example.bookapi.service.BookH2Service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BookController {
    // BookService Bookservice = new BookService();
    @Autowired
    public BookH2Service Bookservice;
    @GetMapping("/books")
    public ArrayList<Book> getBooks(){
        return Bookservice.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBooksById(@PathVariable("bookId") int bookId){
        return Bookservice.getBookbyId(bookId);
    }

    

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return Bookservice.addBook(book);

    }
    
    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
        return Bookservice.updateBook(bookId, book);
    }
    
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        Bookservice.deleteBook(bookId);
    }
    
}
