package com.example.bookapi.model;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.bookapi.model.Book;

public class BookRowMapper implements RowMapper<Book>{

public Book mapRow(ResultSet rs, int Rownum) throws SQLException{
    return new Book(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getString("imageUrl")
    );
}
    
} 
