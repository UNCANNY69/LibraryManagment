package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.User_Book;
import com.bookStore.bookStore.Repository.User_BookRepository;
import org.springframework.stereotype.Service;


@Service

public class Book_Borrow_Service {
    private User_BookRepository repository;
    public User_Book addProduct(User_Book ub){
        return repository.save(ub);
    }

}
