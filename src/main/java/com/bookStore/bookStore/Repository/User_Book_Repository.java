package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Model.User_Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_Book_Repository extends JpaRepository<User_Book,Integer> {
    @Query(value = "SELECT b FROM Book b JOIN User_Book bb ON b.name = bb.book_name")
    List<Book> findBorrowedBooks();
}
