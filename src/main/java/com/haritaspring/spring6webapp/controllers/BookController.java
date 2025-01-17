package com.haritaspring.spring6webapp.controllers;

import com.haritaspring.spring6webapp.services.BookService;
import com.haritaspring.spring6webapp.services.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private final BookService bookService;

    //Constructor Injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books"; // dont return the String book but it return the view names "books"
        //The above line isgoing to tell the spring controller to look for a view called books
    }

}
