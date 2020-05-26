package com.example.mongodb.api;

import com.example.mongodb.model.Product;
import com.example.mongodb.repository.OrderRepository;
import com.example.mongodb.repository.ProductRepository;
import com.example.mongodb.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class HomeApiController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderServices orderServices;

    @RequestMapping("/product/search")
    public List<Product> index(Model model,
                               @RequestParam(value = "name", required = false)String name,
                               @RequestParam("page") int page,
                               @RequestParam("perPage") int perPage){
        List<Product> lstProduct = productRepository.findAll();
        return lstProduct;
    }
    @PostMapping("/get-all-cookie")
    public static List<String> getCookie(@RequestBody String productCart) {
        System.out.println(productCart);
        List<String> lstCookie = new ArrayList<>();
        String itemCookie = "";
        for(int i = 0; i <productCart.length(); i++) {
            char c = productCart.charAt(i);
            if(c  != ',') {
                itemCookie += c;
            }else {
                lstCookie.add(itemCookie);
                itemCookie = "";
            }
        }
        for (String c : lstCookie) {
            System.out.println(c);
        }
        return lstCookie;
    }
}
