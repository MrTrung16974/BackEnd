package com.example.storebook.api;

import com.example.storebook.dto.BaseResponse;
import com.example.storebook.dto.BookRequest;
import com.example.storebook.model.Author;
import com.example.storebook.model.Book;
import com.example.storebook.model.Category;
import com.example.storebook.repository.AuthorRepository;
import com.example.storebook.repository.BookRepository;
import com.example.storebook.repository.CategoryRepository;
import com.example.storebook.service.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class BookAPIController {


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

    @GetMapping("/categorys")
    public BaseResponse getAllCategory() {
        BaseResponse response = new BaseResponse();
        response.setCode("200");
        response.setMess("Success");
        response.setData(categoryRepository.findAll());
        return response;
    }

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


    @GetMapping(value = "/search")
    public BaseResponse searchProduct(@RequestParam("keyword") String keyword){
        BaseResponse response = new BaseResponse();
        List<Book> lstBook =  bookRepository.findByNameContaining(keyword);
        if(!lstBook.isEmpty()) {
            response.setCode("200");
            response.setMess("Delete Book success");
            response.setData(lstBook);
        }else {
            response.setCode("400");
            response.setMess("Data not found");
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
            Author newAuthor = new Author();
            newAuthor.setNameAuthor(bookRequest.getNameAuthor());
            newAuthor.setBirthdayAuthor(bookRequest.getBirthdayAuthor());
            Author exitAuthor = authorRepository.save(newAuthor);
            if(exitAuthor != null) {
                Book newBook = new Book();
                response.setCode("200");
                response.setMess("Success");
                newBook.setName(bookRequest.getName());
                newBook.setDescription(bookRequest.getDescription());
                newBook.setPrice(Float.parseFloat(bookRequest.getPrice()));
                newBook.setStar(Integer.parseInt(bookRequest.getStar()));
                newBook.setImage(bookRequest.getImage());
                newBook.setCategoryId(Integer.parseInt(bookRequest.getCategoryId()));
                newBook.setAuthorId(exitAuthor.getId());
                response.setData(bookRepository.save(newBook));
            }
        }
        return response;
    }

    @PutMapping("/book/{id}")
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
                newAuthor.setNameAuthor(bookRequest.getNameAuthor());
            }
            if(bookRequest.getBirthdayAuthor() != null) {
                newAuthor.setBirthdayAuthor(bookRequest.getBirthdayAuthor());
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
                authorRepository.deleteById(optBook.get().getAuthorId());
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

    @RequestMapping("/book-detail/{id}")
    public Object editDetail(Model model, @PathVariable Integer id) {
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
        return book;
    }

    @PostMapping("/upload")
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
