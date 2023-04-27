package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Admin_Repository  extends JpaRepository<Book,Integer> {
    @Query(value = "SELECT u FROM Role u WHERE u.name='ROLE_USER'")
    public List<Role> getRoles();
//    @Query(value="UPDATE ")
}
