package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Model.Role;
import com.bookStore.bookStore.Repository.Admin_Repository;
import com.bookStore.bookStore.Repository.Role_Repository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Admin_Service {
    private final Admin_Repository adminRepository;
    private Role_Repository roleRepository;

    public Admin_Service(Admin_Repository adminRepository, Role_Repository roleRepository) {
        this.adminRepository = adminRepository;

        this.roleRepository = roleRepository;
    }

    public List<Book> getAllBooks(){
        return adminRepository.findAll();
    }

    public void saveBook(Book book){
        adminRepository.save(book);
    }

    public Book getBookById(int id){
        Optional<Book> optional=adminRepository.findById(id);
        Book book=null;
        if (optional.isPresent()) {
            book = optional.get();
        } else {
            throw new RuntimeException(" Book not found for id :: " + id);
        }
        return book;
    }
    public void deleteBookById(int id) {
        this.adminRepository.deleteById(id);
    }

    public Optional<Role> checkRole(String id, String role){
        return Optional.ofNullable(roleRepository.check(id, role));
    }


}
