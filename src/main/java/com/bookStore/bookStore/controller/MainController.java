package com.bookStore.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String home_admin(){

        return "home_admin";
    }
    @GetMapping("/bookRegister")
    public String bookRegister(){

        return "book_addition";
    }
    @GetMapping("/getAllBooks")
    public String getBooks(){

        return "admin_display";

    }

}
