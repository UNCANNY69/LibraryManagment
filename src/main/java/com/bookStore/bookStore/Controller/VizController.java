package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Repository.Book_Display_Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class VizController {
    private Book_Display_Repository bookDisplayRepository;

    public VizController(Book_Display_Repository bookDisplayRepository) {
        this.bookDisplayRepository = bookDisplayRepository;
    }

    @GetMapping("/viz")
    public String barGraph(Model model){
        List<String> book_name=bookDisplayRepository.findAll().stream().map(Book::getName).toList();
        List<Integer> book_stock=bookDisplayRepository.findAll().stream().map(Book::getStock).toList();
        model.addAttribute("name_list",book_name);
        model.addAttribute("stock_list",book_stock);
        return "barGraph";
    }


}
