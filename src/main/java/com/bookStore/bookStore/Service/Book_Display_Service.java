package com.bookStore.bookStore.service;

import com.bookStore.bookStore.Model.Available_Book;
import com.bookStore.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bRepo;

    public BookService(BookRepository bRepo) {
        this.bRepo = bRepo;
    }

    public List<Available_Book> getRecordsBack(){
        return bRepo.findAll();
    }

}
