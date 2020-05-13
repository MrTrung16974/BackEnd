package com.example.storebook.api;

import com.example.storebook.dto.BaseResponse;
import com.example.storebook.dto.BookRequest;
import com.example.storebook.model.Author;
import com.example.storebook.model.Book;
import com.example.storebook.repository.AuthorRepository;
import com.example.storebook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class BookAPIController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/books")
    public BaseResponse getAllBook() {
        BaseResponse response = new BaseResponse();
        response.setCode("200");
        response.setMess("Success");
        response.setData(bookRepository.findAll());
        return response;
    }

    @GetMapping("/book/{id}")
    public BaseResponse getSinglebook(@PathVariable Integer id) {
        BaseResponse response = new BaseResponse();
        Optional<Book> optProduct = bookRepository.findById(id);
        if(optProduct.isPresent()) {
            response.setCode("00");
            response.setMess("Success");
            response.setData(optProduct.get());
        }else {
            response.setCode("400");
            response.setMess("Error");
            response.setData(null);
        }

        return response;
    }


    @GetMapping("/books/{id}")
    public BaseResponse createBook(@PathVariable Integer id) {
        BaseResponse response = new BaseResponse();
        Optional<Book> optBook = bookRepository.findById(id);
        if(optBook.isPresent()) {
            response.setCode("200");
            response.setMess("Get a Book success");
            response.setData(optBook.get());
        }else {
            response.setCode("400");
            response.setMess("Error");
            response.setData(null);
        }
        return response;
    }

    @PostMapping("/book")
    public BaseResponse createBook(@RequestBody BookRequest bookRequest) {
        BaseResponse response = new BaseResponse();
        if(bookRequest.getName().isEmpty() && bookRequest.getDescription().isEmpty()
                && Float.parseFloat(bookRequest.getPrice()) <= 0 && Integer.parseInt(bookRequest.getStar()) <= 0
                && bookRequest.getImage().isEmpty()) {
            response.setCode("400");
            response.setMess("Data invalid");
            response.setData(null);
        }else {
            Book newBook = new Book();
            Author newAuthor = new Author();
            response.setCode("200");
            response.setMess("Success");
            newBook.setName(bookRequest.getName());
            newBook.setDescription(bookRequest.getDescription());
            newBook.setPrice(Float.parseFloat(bookRequest.getPrice()));
            newBook.setStar(Integer.parseInt(bookRequest.getStar()));
            newAuthor.setName(bookRequest.getNameAuthor());
            newAuthor.setBirthday(bookRequest.getBirthdayAuthor());
            response.setData(bookRepository.save(newBook));
            authorRepository.save(newAuthor);
        }
        return response;
    }

    @PutMapping("/book{id}")
    public BaseResponse editBook(@PathVariable Integer id, @RequestBody BookRequest bookRequest) {
        BaseResponse response = new BaseResponse();
        Optional<Book> optBook = bookRepository.findById(id);
        Optional<Author> optAuthor = authorRepository.findById(optBook.get().getAuthorId());
        if(optBook.isPresent()) {
            Book newBook = optBook.get();
            Author newAuthor = optAuthor.get();
            if(bookRequest.getName().isEmpty()) {
                newBook.setName(bookRequest.getName());
            }
            if(bookRequest.getDescription().isEmpty()) {
                newBook.setDescription(bookRequest.getDescription());
            }
            if(Float.parseFloat(bookRequest.getPrice()) >= 0) {
                newBook.setPrice(Float.parseFloat(bookRequest.getPrice()));
            }
            if(Integer.parseInt(bookRequest.getStar()) >= 0) {
                newBook.setStar(Integer.parseInt(bookRequest.getStar()));
            }
            if(bookRequest.getImage().isEmpty()) {
                newBook.setImage(bookRequest.getImage());
            }
            if(bookRequest.getNameAuthor().isEmpty()) {
                newAuthor.setName(bookRequest.getNameAuthor());
            }
            if(bookRequest.getBirthdayAuthor() != null) {
                newAuthor.setBirthday(bookRequest.getBirthdayAuthor());
            }
            response.setCode("200");
            response.setMess("Edit Book success");
            response.setData(bookRepository.save(newBook));
            authorRepository.save(newAuthor);
        }else {
            response.setMess("400");
            response.setMess("Data Not found");
            response.setData(null);
        }

        return response;
    }

    @DeleteMapping("/book/{id}")
    public BaseResponse deleteBook(@PathVariable Integer id) {
        BaseResponse response = new BaseResponse();
        try {
            Optional<Book> optBook = bookRepository.findById(id);
            if(optBook.isPresent()) {
                bookRepository.deleteById(id);
                response.setCode("200");
                response.setMess("Delete Book success");
                response.setData(optBook.get());
            }else {
                response.setCode("400");
                response.setMess("Data not found");
                response.setData(null);
            }
        }catch (Exception e) {
            response.setCode("900");
            response.setMess("System error :" +  e.getStackTrace());
            response.setData(null);
        }
        return response;
    }

}
