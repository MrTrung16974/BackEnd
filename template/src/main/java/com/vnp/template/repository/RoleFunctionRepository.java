package com.vnp.template.repository;

import com.vnp.template.model.RoleFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleFunctionRepository extends JpaRepository<RoleFunction,Integer> {
}
