package com.example.bookapi.repository;
import java.util.*;

import com.example.bookapi.model.Book;

public interface BookRepository {
  ArrayList<Book> getBooks(); 
  Book getBookbyId(int id);   
  Book addBook(Book book);
  Book updateBook(int bookId, Book book);
  void deleteBook(int bookId);

} 
    
    

