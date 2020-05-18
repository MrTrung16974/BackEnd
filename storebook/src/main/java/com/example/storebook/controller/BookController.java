package com.example.storebook.controller;

import com.example.storebook.api.BookAPIController;
import com.example.storebook.dto.BaseResponse;
import com.example.storebook.model.Author;
import com.example.storebook.model.Book;
import com.example.storebook.model.Category;
import com.example.storebook.repository.AuthorRepository;
import com.example.storebook.repository.BookRepository;
import com.example.storebook.repository.CategoryRepository;
import com.example.storebook.service.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/detail")
    public String detail() {
        return "detail";
    }

}