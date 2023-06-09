package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Book_Search_Repository extends JpaRepository<Book,Integer> {
    @Query(value = "SELECT b FROM Book b WHERE "
            + "b.name LIKE CONCAT('%',:query,'%') and b.availability = 'Yes' ")
    List<Book> searchBookSQL(String query);

}
