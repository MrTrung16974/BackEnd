package com.example.springsecurity.repository;


import com.example.springsecurity.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
    Optional<Order> findByBuyerAndStatus(String id, Integer status);
}
