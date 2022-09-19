package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class LibraryController {


    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }



    @GetMapping("/getBooks")
    public List<Book> getBooks(){

        return libraryService.getBooks();
    }

    @GetMapping("/getStatistics")
    public Map<Character,List<Book>> getStatistic(){
        return libraryService.getStatistic();
    }

    @GetMapping("/getBooksByLetter/{letter}")
    public List<Book> getBooksByLetter(@PathVariable String letter){

        return libraryService.getBooksByLetter(letter);

    }
    @PostMapping("/add")
    public void addBook(){
        Book book = new Book("folstig", "prohorov", "issbbnn");
        libraryService.addBook(book);
    }


}
