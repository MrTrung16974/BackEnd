package com.example.backendkyc.reposiroty;

import com.example.backendkyc.model.Function;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FunctionRepository extends
        MongoRepository<Function,String> {
}
