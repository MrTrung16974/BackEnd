package com.example.mongodb;

import com.example.mongodb.model.Product;
import com.example.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbApplication  {
//  implements CommandLineRunner
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

//    @Autowired
//    ProductRepository productRepository;

//    @Override
//    public void  run(String...args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            Product p = new Product();
//            p.setName("Name " + i);
//            p.setPrice((double)i*100);
//            p.setNumber(i);
//            productRepository.save(p);
//        }
//    }
}
