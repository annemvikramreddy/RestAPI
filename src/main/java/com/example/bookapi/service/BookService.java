package com.example.bookapi.service;
import java.util.*;

import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;


public class BookService implements BookRepository{
   private HashMap<Integer, Book> hmap = new HashMap<>();
   int uniqueId = 3;

   public BookService(){
    Book b1 = new Book(1, "Harry Potter", "J.K. Rowling");
    Book b2 = new Book(2, "The Hunger Games", "Suzanne Collins");

    hmap.put(b1.getId(),b1);
    hmap.put(b2.getId(),b2);
   }

   @Override
   public ArrayList<Book> getBooks(){
    Collection<Book> BookCollection = hmap.values();
    ArrayList<Book> BookList = new ArrayList<Book>(BookCollection);
    return BookList;
   }

   @Override
   public Book getBookbyId(int id){
    Book book = hmap.get(id);
    if(book ==null){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return book;
   }

   @Override
   public Book addBook( Book book){
    book.setId(uniqueId);
    hmap.put(uniqueId,book);
    uniqueId+=1;
    return book;

    }
    @Override
    public Book updateBook(int bookId, Book book) {
        Book existingBook = hmap.get(bookId);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (book.getname() != null) {
            existingBook.setname(book.getname());
        }
        if (book.getimageUrl() != null) {
            existingBook.setimageUrl(book.getimageUrl());
        }
        return existingBook;

    }
    
    @Override
    public void deleteBook(int bookId) {
        Book book = hmap.get(bookId);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            hmap.remove(bookId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        }

    }
   }

