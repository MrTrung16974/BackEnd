package com.example.admin_mvc.controller;

import com.example.admin_mvc.exception.ResourceNotFoundException;
import com.example.admin_mvc.model.ProductModel;
import com.example.admin_mvc.repository.ProductRepository;
import com.example.admin_mvc.service.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreFileService storeFileService;

    private List<ProductModel> list;

    @GetMapping(value = "/home")
    public String homeProduct(Model model){
        String message = "";
        if(list == null ) {
            list = productRepository.findAll();
        }
        model.addAttribute("lstProduct",list);
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping(value = "/search/{name}")
    public String searchProduct(Model model, @PathVariable("name") String name){
        String message = "";
        list = productRepository.searchProduct(name);
        model.addAttribute("lstProduct",list);
        model.addAttribute("message", message);
        return "redirect:/home";
    }
    @RequestMapping(value = "/delete/{id}" )
    public String deleteProduct(Model model, @PathVariable("id") Integer id) {
        String message = null;
        if(id != null) {
            message = "Bạn đã xóa thành công product";
            productRepository.deleteById(id);
        }else {
            message = "Không tìm thấy sản phẩm";
        }
        model.addAttribute("message", message);
        return "redirect:/home";
    }

    @RequestMapping(value = "/create-product",  method = RequestMethod.POST)
    @ResponseBody //không trả về trang web
    public void createNewProduct(@RequestBody ProductModel product){
        String message = null;
        if(product != null) {
            message = "Bạn đã thêm thành công product";
            productRepository.save(product);
        }else {
            message = "Bạn nhập sai òi";
        }
    }

    @RequestMapping(value = "/edit/{id}/detail")
    public String editProduct(Model model, @PathVariable("id") Integer id) {
        ProductModel productModel = null;
        for (ProductModel p : list) {
            if(p.getId() == id) {
                productModel = p;
            }
        }
        model.addAttribute("product", productModel);
        return "detail";
    }

    @PostMapping(value = "/edit/{id}")
    @ResponseBody
    public int editProduct(Model model,@PathVariable("id") int id, @RequestBody ProductModel product) {
        String message = null;
        product.setId(id);
        System.out.println(product);
//        ProductModel productModel = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        if (product.getDescription() != null && !product.getDescription().isEmpty()) {
            message = "Bạn đã thêm thành công product";
            productRepository.updateProduct(product.getId(), product.getName(),
                    product.getDescription(), product.getPrice(), product.getStar(), product.getImage());
        } else {
            message = "Bạn nhập sai òi";
            return 4;
        }
        model.addAttribute("message", message);
        return 0;
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
