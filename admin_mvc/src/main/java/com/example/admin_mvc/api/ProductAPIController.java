package com.example.admin_mvc.api;

import com.example.admin_mvc.model.BaseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class ProductAPIController {

//    @RequestParam(value =/ "/product", method= RequestMethod.GET)
    @GetMapping("/product")
    public BaseResponse getAllProduct() {
        BaseResponse response = new BaseResponse();
        response.setMessge("Success");
        response.setCode("00");
        response.setData(null);
        return response;
    }

}
