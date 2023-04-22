package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Repository.Book_Display_Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Book_Display_Service {
    private final Book_Display_Repository bRepo;

    public Book_Display_Service(Book_Display_Repository bRepo) {
        this.bRepo = bRepo;
    }

    public List<Book> getRecordsBack(){
        return bRepo.findAllBooks();
    }

    public void updateBook(int id){
        bRepo.updateBook(id);
    }

    public void updateBorrowedBook(int id){
        bRepo.updateBorrowedBook(id);
    }

    public void updateBorrowedUser(String s,String id){
        bRepo.updateBorrowedUser(s,id);
    }
    public List<Book> getBorrowedBooks(String name){
        return bRepo.findBorrowedBooks(name);
    }
}
