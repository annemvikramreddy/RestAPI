package com.example.bookapi.model;
import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {
   @Id
   @Column(name="id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name="name")
   private String name;
   @Column(name="imageurl")
   private String imageUrl;

   public Book(){}

   public Book(int id,String name,String imageUrl){
    this.id= id;
    this.name= name;
    this.imageUrl = imageUrl;
   }

   public int getId(){
    return this.id;
   }

   public void setId(int id){
    this.id = id;
   }

   public String getname(){
    return this.name;
   }

   public void setname(String name){
    this.name = name;
   }

   public String getimageUrl(){
    return this.imageUrl;
   }

   public void setimageUrl(String imageUrl){
    this.imageUrl = imageUrl;
   }
}
