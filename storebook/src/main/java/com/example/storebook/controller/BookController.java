package com.example.storebook.controller;

import com.example.storebook.api.BookAPIController;
import com.example.storebook.dto.BaseResponse;
import com.example.storebook.model.Book;
import com.example.storebook.repository.BookRepository;
import com.example.storebook.service.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    StoreFileService storeFileService;

    @Autowired
    private BookAPIController bookAPIController;

    @RequestMapping("/home")
    public String home(Model model) {
        BaseResponse response =  bookAPIController.getAllBook();
        String mess = null;
        if(response.getData() != null) {
            mess = "Thành công";
            model.addAttribute("lstBook", response.getData());
        }else {
            mess = "Không có sản phẩm";
        }
        model.addAttribute("mess", mess);
        return "index";
    }

    @RequestMapping("/book-detail/{id}")
    public String editDetail(Model model, @PathVariable Integer id) {
        BaseResponse response =  bookAPIController.getSinglebook(id);
        String mess = null;
        if(response.getData() != null) {
            model.addAttribute("book", response.getData());
            mess = "Thành công";
        }else {
            mess = "Sản phẩm không tồn tại";
        }
        model.addAttribute("mess", mess);
        return "index";
    }

    @GetMapping(value = "/search")
    public String searchProduct(Model model, @RequestParam("keyword") String keyword){
        String message = "";
        List<Book> lstBook =  bookRepository.searchBook(keyword);
        model.addAttribute("lstBook", lstBook);
        model.addAttribute("message", message);
        return "redirect:/home";
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