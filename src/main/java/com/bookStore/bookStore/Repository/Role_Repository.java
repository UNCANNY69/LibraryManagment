package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Role_Repository extends JpaRepository<Role,String> {
    @Query(value = "SELECT r FROM Role r WHERE r.id_name=:id AND r.name=:role")
    public Role check(String id,String role);

}
