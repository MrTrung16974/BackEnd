package com.vnp.template.service.impl;

import com.vnp.template.exception.BaseException;
import com.vnp.template.exception.EntityType;
import com.vnp.template.exception.ExceptionType;
import com.vnp.template.model.Role;
import com.vnp.template.repository.RoleRepository;
import com.vnp.template.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger LOGGER = LogManager.getLogger(RoleService.class);

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByID(Integer roleID) {
        return roleRepository.findById(roleID).orElseThrow(
                () -> BaseException.throwException(EntityType.ROLE, ExceptionType.ENTITY_NOT_FOUND, roleID + ""));
    }
}
