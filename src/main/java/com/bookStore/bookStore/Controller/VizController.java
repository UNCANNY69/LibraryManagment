package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Model.Viz1;
import com.bookStore.bookStore.Repository.Book_Display_Repository;
import com.bookStore.bookStore.Repository.Viz_1_Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class VizController {
    private final Book_Display_Repository bookDisplayRepository;
    private final Viz_1_Repository viz1Repository;

    public VizController(Book_Display_Repository bookDisplayRepository, Viz_1_Repository viz1Repository) {
        this.bookDisplayRepository = bookDisplayRepository;
        this.viz1Repository = viz1Repository;
    }

    @GetMapping("/viz")
    public String barGraph(Model model){
        List<String> book_name=bookDisplayRepository.findAll().stream().map(Book::getName).toList();
        List<Integer> book_stock=bookDisplayRepository.findAll().stream().map(Book::getStock).toList();
        model.addAttribute("name_list",book_name);
        model.addAttribute("stock_list",book_stock);
        return "barGraph";
    }
    @GetMapping("/viz2")
    public String lineGraph(Model model){
//        List<Viz1> list= viz1Repository.findAll();
        List<String> user_name=viz1Repository.findAll().stream().map(Viz1::getUser_id).toList();
        List<Integer> book_stock=viz1Repository.findAll().stream().map(Viz1::getBorrowed).toList();
        model.addAttribute("name_list",user_name);
        model.addAttribute("borrowed_list",book_stock);
        return "lineGraph";
    }

}
