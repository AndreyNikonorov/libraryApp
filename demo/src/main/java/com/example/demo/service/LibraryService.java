package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final BookRepository repository;


    public LibraryService(BookRepository repository) {
        this.repository = repository;
    }



    public List<Book> getBooks(){
        List<Book> booksList = repository.findAll();
        return booksList;
    }

    public Map<Character,List<Book>> getStatistic() {
        List<Book> booksList = repository.findAll();
        Map<Character,List<Book>> categoriedMap =
                booksList.stream().collect(Collectors.groupingBy(x -> x.getName().charAt(0)));

        return categoriedMap;
    }

    public List<Book> getBooksByLetter(String letter){
        List<Book> bookList = repository.findAll().stream().filter(x ->
                (x.getName().startsWith(letter))).collect(Collectors.toList());

        return bookList;
    }

    public void addBook(Book book){
        repository.save(book);
    }
}
