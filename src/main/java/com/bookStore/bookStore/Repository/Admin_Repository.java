package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Admin_Repository  extends JpaRepository<Book,Integer> {

}
