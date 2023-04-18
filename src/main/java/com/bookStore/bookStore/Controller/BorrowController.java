package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.User_Book;
import com.bookStore.bookStore.Repository.Book_Display_Repository;
import com.bookStore.bookStore.Service.Book_Borrow_Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class BorrowController {

    private final Book_Borrow_Service bbs;
    private final Book_Display_Repository bdr;
    public BorrowController(Book_Borrow_Service bbs, Book_Display_Repository bdr) {
        this.bbs = bbs;
        this.bdr = bdr;
    }
    @GetMapping("/add/{id}")
    public RedirectView addBook(@RequestParam("b") String s, @PathVariable int id){
        User_Book ub  = new User_Book(id,SecurityContextHolder.getContext().getAuthentication().getName(),s);
        bbs.addProduct(ub);
        bdr.updateBook(id);
        return new RedirectView("/", true);
    }

    @GetMapping("/return/{id}")
    public RedirectView returnBook( @RequestParam("b") String s,@PathVariable int id){
        bdr.updateBorrowedBook(id);
        bdr.updateBorrowedUser(s,id);
        return new RedirectView("/", true);
    }

}
