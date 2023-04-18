package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Model.User_Book;
import com.bookStore.bookStore.Repository.User_BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Book_Borrow_Service {
    private final User_BookRepository repository;

    public Book_Borrow_Service(User_BookRepository repository) {
        this.repository = repository;
    }

    public void addProduct(User_Book ub){
        repository.save(ub);
    }

    public List<Book> getBorrowedBack(){
        return repository.findBorrowedBooks() ;
    }


}
