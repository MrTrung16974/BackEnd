package com.example.storebook.api;

import com.example.storebook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAPIController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String getAllBook() {

    }
}
