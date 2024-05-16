package com.example.bookapi.service;
import com.example.bookapi.repository.BookRepository;
import com.example.bookapi.model.Book;
import com.example.bookapi.model.BookRowMapper;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class BookH2Service implements BookRepository{
    
    @Autowired
    private JdbcTemplate db;
    @Override
    public ArrayList<Book> getBooks(){
        List<Book> bookList = db.query("SELECT * FROM book",new BookRowMapper());
        ArrayList<Book> books = new ArrayList<>(bookList);
        return books;
    }

    @Override
    public Book getBookbyId(int bookId){
        try{
        Book book = db.queryForObject("SELECT * FROM book WHERE id=?",new BookRowMapper(),bookId);
        return book;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Book addBook(Book book){
        db.update("INSERT into book(name,imageUrl) values(?,?)",book.getname(),book.getimageUrl());
        Book Savedbook = db.queryForObject("SELECT * FROM book WHERE name=? and imageUrl= ?", new BookRowMapper(), book.getname(),book.getimageUrl());
        return Savedbook;
    }
    
    @Override
    public Book updateBook(int bookId,Book book){
        if(book.getname()!=null){
            db.update("UPDATE book SET name =? WHERE id =?",book.getname(),bookId);
        }
        if(book.getimageUrl()!=null){
            db.update("UPDATE book SET imageUrl =? WHERE id =?",book.getimageUrl(),bookId);
        }
        return getBookbyId(bookId);
    }
    @Override
    public void deleteBook(int id){
        db.update("DELETE from book where id =?",id);
    }
}
