package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Controller.Dto.UserRegistrationDto;
import com.bookStore.bookStore.Service.User_Registartion_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserController {
    @Autowired
    private User_Registartion_Service user_service;
    public UserController(User_Registartion_Service user_service){
        super();
        this.user_service = user_service;
    }
    @GetMapping
    public String show_reg(Model model){
        model.addAttribute("user",new UserRegistrationDto());
        return "registration";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto reg ){
        user_service.save(reg);
        return "redirect:/registration?success";
    }



}
