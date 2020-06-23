package com.example.backendkyc.reposiroty;

import com.example.backendkyc.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoleRepository extends MongoRepository<Role,String> {
    List<Role> findByRoleCodeAndStatus(String code, Integer status);
    Role findByRoleCode(String roleCode);
}
