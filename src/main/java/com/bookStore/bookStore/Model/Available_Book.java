package com.bookStore.bookStore.Model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private  int pages;
    private int stock;

    public Book(int id, String name, String author, int pages, int stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.stock = stock;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
