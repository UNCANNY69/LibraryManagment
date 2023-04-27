package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Model.Role;
import com.bookStore.bookStore.Service.Admin_Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class Admin_Controller {
    private final Admin_Service adminService;

    public Admin_Controller(Admin_Service adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String viewHomePage(Model model){
        model.addAttribute("listBooks",adminService.getAllBooks());
        return "admin";
    }
    @GetMapping("/showNewBookForm")
    public String showNewEmployeeForm(Model model) {
        Book book = new Book();
        model.addAttribute("book",book);
        return "new_book";
    }
    @PostMapping("/saveBook")
    public String saveEmployee(@ModelAttribute("book") Book book) {
        adminService.saveBook(book);
        return "redirect:/admin";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Book book = adminService.getBookById(id);
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id) {
        this.adminService.deleteBookById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin_check")
    public String check(){
        Optional<Role> role = adminService.checkRole(SecurityContextHolder.getContext().getAuthentication().getName(),"ROLE_ADMIN");
        if (role.isPresent()){
            return "redirect:/admin";
        }
        return "denied";
    }
    @GetMapping("/sys_admin")
    public String getUsers(Model model){
        model.addAttribute("listRoles",adminService.getRoles());
        return "systemAdmin";
    }
    @GetMapping("/add_role/{user_id}")
    public void updateRole(@PathVariable String user_id){

    }

}
