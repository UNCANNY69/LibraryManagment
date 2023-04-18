package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Book_Display_Repository extends JpaRepository<Book,Integer> {
    @Query(value = "SELECT b FROM Book b WHERE "
            + "b.availability = 'Yes' ")
    List<Book> findAllBooks();

    @Modifying
    @Transactional
    @Query(value="UPDATE Book b SET b.availability = 'No' WHERE b.id = :id ")
    void updateBook(int id);
    
}
