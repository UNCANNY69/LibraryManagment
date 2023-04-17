package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Model.User_Book;
import com.bookStore.bookStore.Service.Book_Borrow_Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BorrowController {

    private final Book_Borrow_Service bbs;
    public BorrowController(Book_Borrow_Service bbs) {
        this.bbs = bbs;
    }
    @GetMapping("/add")
    public String addBook(@RequestParam("b") String s,Model model){
        User_Book ub  = new User_Book(SecurityContextHolder.getContext().getAuthentication().getName(),s);
        bbs.addProduct(ub);
        List<Book> list=bbs.getBorrowedBack() ;
        model.addAttribute("book",list);
        return "index";
    }
}
