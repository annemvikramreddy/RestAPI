package com.example.bookapi.model;

public class Book {
   private int id;
   private String name;
   private String imageUrl;

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
