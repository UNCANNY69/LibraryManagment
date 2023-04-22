package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Model.User_Book;
import com.bookStore.bookStore.Repository.User_Book_Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Book_Borrow_Service {
    private final User_Book_Repository repository;

    public Book_Borrow_Service(User_Book_Repository repository) {
        this.repository = repository;
    }

    public void addProduct(User_Book ub){
        repository.save(ub);
    }

    public List<Book> getBorrowedBack(){
        return repository.findBorrowedBooks() ;
    }

}
