package com.example.admin_mvc.controller;

import com.example.admin_mvc.model.ProductModel;
import com.example.admin_mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    List<ProductModel> list = new ArrayList<>();

    @RequestMapping(value = "/home{name}",method = RequestMethod.GET)
    public String homeProduct(Model model, @PathVariable(name = "name") String name){
        String message = "";
        if(!name.isEmpty()) {
            list = productRepository.searchProduct(name);
        }else{
            list = productRepository.findAll();
        }
        model.addAttribute("lstProduct",list);
        model.addAttribute("message", message);
        return "index";
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

    @RequestMapping(value = "/edit/{id}")
    public String editProduct(Model model, @PathVariable("id") int id) {
        ProductModel product = null;
        String message = null;
        for (ProductModel p : list) {
            if(p.getId() == id) {
                product = p;
            }
        }
        if(product != null) {
            message = "Bạn đã thêm thành công product";
//            productRepository.updateProduct(product.getId(), product.getName(),
//                    product.getDescription(), product.getPrice(), product.getStar());
        }else {
            message = "Bạn nhập sai òi";
        }
        model.addAttribute("message", message);
        return "redirect:/detail";
    }
}
