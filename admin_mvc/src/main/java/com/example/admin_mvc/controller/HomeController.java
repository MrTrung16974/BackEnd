package com.example.admin_mvc.controller;

import com.example.admin_mvc.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<Product> lstProduct = new ArrayList<>();

    @PostConstruct
    public void mockUp() {
        lstProduct.add(new Product("Product1", "Description Product 1", 100, 5));
        lstProduct.add(new Product("Product2", "Description Product 2", 123, 5));
        lstProduct.add(new Product("Product3", "Description Product 3", 123, 3));
        lstProduct.add(new Product("Product2", "Description Product 4", 100, 2));
        lstProduct.add(new Product("Product2", "Description Product 5", 123, 6));
        lstProduct.add(new Product("Product3", "Description Product 6", 123, 1));
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("lstProduct", lstProduct);
        model.addAttribute("message", "Thành Công3");
        return "index";
    }
//    các create dât bằng url (dài dòng)
    @RequestMapping("/create-product")
    public String createGame(Model model,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") int price,
                             @RequestParam("star") int star) {
        System.out.println(name);
        System.out.printf(description);
        System.out.println(price);
        System.out.println(star);
        String  message = "";
        if(name != null && description != null && price > 0 && star > 0) {
            message = "Thành Công1";
            lstProduct.add(new Product(name, description, price, star));
        }else {
            message = "ko hợp lệ";
        }
        model.addAttribute("message", message);
        model.addAttribute("lstProduct", lstProduct);

        return "index";
    }

//    crate product bằng @ResquestBody()
//   data json gửi lên từ client Resquestbody() sẽ nói Spring convert data json ra product binh thường
    @RequestMapping(value = "/create-product", method = RequestMethod.POST)
    public String createNewProduct(Model model, @RequestBody Product product) {
        lstProduct.add(product);
        model.addAttribute("lstProduct", lstProduct);
        model.addAttribute("message", "Thành Công2");
            return  "redirect:index";
    }

}
