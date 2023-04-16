package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.Available_Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Available_Book,Integer> {
    @Query(value = "SELECT b FROM Available_Book b WHERE "
            + "b.name LIKE CONCAT('%',:query,'%')")
    List<Available_Book> searchBookSQL(String query);
}
