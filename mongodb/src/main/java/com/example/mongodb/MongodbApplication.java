package com.example.mongodb;


import com.example.mongodb.model.Image;
import com.example.mongodb.model.Product;
import com.example.mongodb.model.Promotion;
import com.example.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbApplication {
//        implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Override
//    public void  run(String...args) throws Exception {
//        for (int i = 30; i <35; i++) {
//            Product p = new Product();
//            p.setName("Name " + i);
//            p.setPrice((double)i*100);
//            p.setType(4);
//            p.setColor(5);
//            p.setMaterial(2);
//            p.setPromotion(new Promotion("1/4", 20));
//            p.setStar(4);
//            p.setImage(new Image("http://localhost:8099/link/1590817275-1.jpg",
//                    "http://localhost:8099/link/1590817275-1.jpg",
//                    "http://localhost:8099/link/1590817275-1.jpg",
//                    "http://localhost:8099/link/1590817275-1.jpg"));
//            p.setId(""+i);
//            productRepository.save(p);
//        }
//        System.out.println("End");
//    }
}
