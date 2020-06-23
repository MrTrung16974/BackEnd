package com.example.backendkyc.reposiroty;

import com.example.backendkyc.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User,String> {
        Optional<User> findByUserName(String name);
        List<User> findByStatus(Integer status);
}