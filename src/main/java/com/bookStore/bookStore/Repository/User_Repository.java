package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
