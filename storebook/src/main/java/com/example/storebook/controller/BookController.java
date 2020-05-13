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

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    StoreFileService storeFileService;

    @Autowired
    private BookAPIController bookAPIController;

    @RequestMapping("/home")
    public String home(Model model) {
        BaseResponse response =  bookAPIController.getAllBook();
        List<Category> lstCategory = categoryRepository.findAll();
        String mess = null;
        if(response.getData() != null) {
            mess = "Thành công";
            model.addAttribute("lstBook", response.getData());
            model.addAttribute("lstCategory", lstCategory);
        }else {
            mess = "Không có sản phẩm";
        }
        model.addAttribute("mess", mess);
        return "index";
    }

    @RequestMapping("/book-detail/{id}")
    public String editDetail(Model model, @PathVariable Integer id) {
        String formatDate = null;
        BaseResponse responseBook =  bookAPIController.getSinglebook(id);
        Book book = (Book) responseBook.getData();
        Optional<Author> responseAuthor =  authorRepository.findById(book.getAuthorId());
        List<Category> lstCategory = categoryRepository.findAll();
        try {
            Date date = responseAuthor.get().getBirthdayAuthor();
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
            if(date != null) {
                formatDate = sm.format(date);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        String mess = null;
        if(responseBook.getData() != null && responseAuthor.isPresent() && lstCategory != null) {
            model.addAttribute("book", responseBook.getData());
            model.addAttribute("author", responseAuthor.get());
            model.addAttribute("birthdayAuthor", formatDate);
            model.addAttribute("lstCategory", lstCategory);
            mess = "Thành công";
        }else {
            mess = "Sản phẩm không tồn tại";
        }
        model.addAttribute("mess", mess);
        return "detail";
    }

    @GetMapping(value = "/search")
    public String searchProduct(Model model, @RequestParam("keyword") String keyword){
        String message = "";
        List<Book> lstBook =  bookRepository.searchBook(keyword);
        model.addAttribute("lstBook", lstBook);
        model.addAttribute("message", message);
        return "index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        String fileName = "";
        String fileLink = "http://localhost:8080/link/";
        try{
            if(file.isEmpty()) {
                throw new Exception();
            }
            fileName = storeFileService.store(file);
            fileLink += fileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileLink;
    }
}