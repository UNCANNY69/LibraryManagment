package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.User_Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_BookRepository extends JpaRepository<User_Book,Integer> {
}
