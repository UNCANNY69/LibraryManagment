package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Available_Book;
import com.bookStore.bookStore.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Book_Display_Service {
    private final BookRepository bRepo;

    public Book_Display_Service(BookRepository bRepo) {
        this.bRepo = bRepo;
    }

    public List<Available_Book> getRecordsBack(){
        return bRepo.findAll();
    }

}
