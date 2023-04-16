package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Available_Book;
import com.bookStore.bookStore.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Book_Search_Service {
    private final BookRepository bookRepository;

    public Book_Search_Service(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Available_Book> searchBooks(String query){
        if(query!=null) {
            return bookRepository.searchBookSQL(query);
        }
        return bookRepository.findAll();
    }
}
