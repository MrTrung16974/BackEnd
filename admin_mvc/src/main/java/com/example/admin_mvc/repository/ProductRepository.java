package com.example.admin_mvc.repository;

import com.example.admin_mvc.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {

//    @Modifying
//    @Transactional
//    @Query("UPDATE product p SET p.name = :name, p.description = :description, p.price = :price, p.star = :star WHERE id = :id")
//    void updateProduct(@Param("id") int id, @Param("name") String name, @Param("description") String description, @Param("price")
//            float price, @Param("star") int star);

    @Query(value = "SELECT * from product p WHERE p.name LIKE %:name%", nativeQuery = true)
    List<ProductModel> searchProduct(@Param("name") String name);
}
