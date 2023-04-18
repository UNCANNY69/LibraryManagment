package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Repository.Book_Display_Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Book_Display_Service {
    private final Book_Display_Repository bRepo;

    public Book_Display_Service(Book_Display_Repository bRepo) {
        this.bRepo = bRepo;
    }

    public List<Book> getRecordsBack(){
        return bRepo.findAllBooks();
    }

    public Void updateBook(int id){
        bRepo.updateBook(id);
        return null;
    }
}
