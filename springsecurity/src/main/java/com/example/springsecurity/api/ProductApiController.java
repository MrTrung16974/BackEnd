package com.example.springsecurity.api;

import com.example.springsecurity.dto.BaseResponse;
import com.example.springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductApiController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public BaseResponse findProductByCategory(@RequestParam("type") Integer type) {
        BaseResponse response = new BaseResponse();
        return response;
    }
}
