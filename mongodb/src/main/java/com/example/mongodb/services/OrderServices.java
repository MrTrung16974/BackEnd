package com.example.mongodb.services;

import com.example.mongodb.model.Product;
import com.example.mongodb.repository.ProductRepository;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServices {

//    MongoTemplate mongoTemplate =
//            new MongoTemplate(new MongoClient("127.0.0.1"),"yourdb");
//
//    @Override
//    public ​List<Product> findHotStoriesOfGroup(String groupId) {
//       ​Query query = new Query();
//       ​query.with(new Sort(Sort.Direction.DESC, "this.comments.length"));
//       ​query.addCriteria(Criteria.where("groupId").is(groupId));
//
//       ​return mongoTemplate.find(query, Story.class);
//    }
}
