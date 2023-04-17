package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Service.Book_Display_Service;

import com.bookStore.bookStore.Service.Book_Search_Service;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class MainController {
    private final Book_Display_Service service_d;
    private final Book_Search_Service service_s;
    public MainController(Book_Display_Service service, Book_Search_Service serviceS) {
        this.service_d = service;
        this.service_s = serviceS;
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


//    @GetMapping("/add")
//    public String addBook()
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
