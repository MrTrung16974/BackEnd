package com.example.mongodb.api;

import com.example.mongodb.dto.BaseResponse;
import com.example.mongodb.model.Product;
import com.example.mongodb.model.ProductModel;
import com.example.mongodb.repository.OrderRepository;
import com.example.mongodb.repository.ProductRepository;
import com.example.mongodb.services.OrderServices;
import com.example.mongodb.services.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/v1/api")
public class HomeApiController {

    @Autowired
    StoreFileService storeFileService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderServices orderServices;

    //    Upload file img
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        String fileName = "";
        String fileLink = "http://localhost:8099/link/";
        try {
            if(file.isEmpty()) {
                throw new Exception();
            }
            fileName = storeFileService.store(file);
            fileLink += fileName;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return fileLink;
    }

    @GetMapping("/product/search")
    public BaseResponse index( @RequestParam(value = "name", required = false)String name,
                               @RequestParam(value = "material", required = false)String material,
                               @RequestParam(value = "color", required = false)String color,
                               @RequestParam(value = "type", required = false)String type,
                               @RequestParam("page") int page,
                               @RequestParam("perPage") int perPage){
        BaseResponse response = new BaseResponse();
        try {
            Pageable pageable = PageRequest.of(page, perPage, Sort.by(Sort.Direction.ASC,"id"));
            Page<Product> listProduct = productRepository.findByNameContaining(name.toLowerCase(),pageable);
            Integer totalPage = listProduct.getTotalPages();
            if (!listProduct.isEmpty()) {
                response.setCode("00");
                response.setMessage("List actor search by key: " + name);
                response.setData(listProduct);
            } else {
                response.setCode("99");
                response.setMessage("Data not found");
                response.setData(null);
            }
        } catch (Exception e) {
            response.setCode("90");
            response.setMessage("System erorr : " + e.getMessage());
            response.setData(null);
        }
        return response;
    }

    @GetMapping("/product/{id}")
    public BaseResponse getSingleProduct(@PathVariable("id") String id){
        BaseResponse response = new BaseResponse();
        try {
            Optional<Product> optListProduct = productRepository.findById(id);
            if (optListProduct.isPresent()) {
                response.setCode("00");
                response.setMessage("List actor search by key: " + id);
                response.setData(optListProduct);
            } else {
                response.setCode("99");
                response.setMessage("Data not found");
                response.setData(null);
            }
        } catch (Exception e) {
            response.setCode("90");
            response.setMessage("System erorr : " + e.getMessage());
            response.setData(null);
        }
        return response;
    }

    @PostMapping("/product")
    public BaseResponse createProduct(
            @RequestBody ProductModel productRequest){
        BaseResponse response = new BaseResponse();
        if(productRequest == null) {
            response.setCode("99");
            response.setMessage("Found not data");
            response.setData(null);
            return response;
        }
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setNumber(0);
        product.setImage(productRequest.getImage());
        product.setType(productRequest.getType());
        product.setPrice(productRequest.getPrice());
        product.setPromotion(productRequest.getPromotion());
        product.setMaterial(productRequest.getMaterial());
        product.setColor(productRequest.getColor());
        product.setStar(productRequest.getStar());
        product.setCreateAt(new Date());
        Product exitProduct = productRepository.save(product);
        response.setCode("00");
        response.setMessage("Success");
        response.setData(exitProduct);
        return response;
    }

    @PutMapping("/product/{id}")
    public BaseResponse editProduct(@PathVariable("id") String id,
            @RequestBody ProductModel productRequest){
        BaseResponse response = new BaseResponse();
        Optional<Product> optProduct = productRepository.findById(id);

        if(!optProduct.isPresent()) {
            response.setCode("99");
            response.setMessage("Found not data");
            response.setData(null);
            return response;
        }
        Product oldProduct = optProduct.get();
        Product newProduct = new Product();
        if(!productRequest.getName().isEmpty()) {
            newProduct.setName(oldProduct.getName());
        }
        if(productRequest.getNumber() > 0) {
            newProduct.setNumber(0);
        }
        if(productRequest.getImage() != null) {
            newProduct.setImage(oldProduct.getImage());
        }
        if(productRequest.getType() > 0) {
            newProduct.setType(oldProduct.getType());
        }
        if(productRequest.getPrice() > 0) {
            newProduct.setPrice(oldProduct.getPrice());
        }
        if(productRequest.getColor() > 0) {
            newProduct.setColor(oldProduct.getColor());
        }
        if(productRequest.getMaterial() > 0) {
            newProduct.setMaterial(oldProduct.getMaterial());
        }
        if(productRequest.getPromotion() != null) {
            newProduct.setPromotion(oldProduct.getPromotion());
        }
        if(productRequest.getStar() > 0) {
            newProduct.setStar(oldProduct.getStar());
        }
        Product exitProduct = productRepository.save(newProduct);
        response.setCode("00");
        response.setMessage("Edit Success");
        response.setData(exitProduct);
        return response;
    }

    @DeleteMapping("/product/{id}")
    public BaseResponse deleteProduct(@PathVariable("id") String id){
        BaseResponse response = new BaseResponse();
        Optional<Product> optProduct = productRepository.findById(id);

        if(!optProduct.isPresent()) {
            response.setCode("99");
            response.setMessage("Found not data");
            response.setData(null);
            return response;
        }
        Product exitProduct = optProduct.get();
        productRepository.delete(exitProduct);
        response.setCode("00");
        response.setMessage("Delete Success");
        response.setData(exitProduct);
        return response;
    }


}
