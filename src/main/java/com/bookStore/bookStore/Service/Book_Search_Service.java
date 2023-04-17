package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Repository.Book_Search_Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Book_Search_Service {
    private final Book_Search_Repository bookSearchRepository;

    public Book_Search_Service(Book_Search_Repository bookSearchRepository) {
        this.bookSearchRepository = bookSearchRepository;
    }
    public List<Book> searchBooks(String query){
        if(query!=null) {
            return bookSearchRepository.searchBookSQL(query);
        }
        return bookSearchRepository.findAll();
    }
}
