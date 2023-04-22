package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Service.Book_Borrow_Service;
import com.bookStore.bookStore.Service.Book_Display_Service;
import com.bookStore.bookStore.Service.Book_Search_Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    private final Book_Display_Service service_d;
    private final Book_Search_Service service_s;
    private final Book_Borrow_Service service_b;

    public MainController(Book_Display_Service service, Book_Search_Service serviceS, Book_Borrow_Service service_b) {
        this.service_d = service;
        this.service_s = serviceS;
        this.service_b = service_b;
    }

    @GetMapping("/")
    public String getAllBooks(Model model ){
        List<Book> list=service_d.getRecordsBack();
        model.addAttribute("book",list);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user",user);
        return "index";
    }

    @GetMapping("/search")
    public String getSearchedBooks(@RequestParam("s") String s,Model model){
        List<Book> s_list=service_s.searchBooks(s);
        model.addAttribute("book",s_list);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/borrowed")
    public String borrow(Model model){
        List<Book> list=service_d.getBorrowedBooks(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("book",list);
        return "borrowed";
    }

    @GetMapping("/red")
    public RedirectView redirect(){
        return new RedirectView("/", true);
    }


}
