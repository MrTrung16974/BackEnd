package com.example.backendkyc.service;

import com.example.backendkyc.model.Role;
import com.example.backendkyc.reposiroty.RoleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private static final Logger LOGGER = LogManager.getLogger(RoleService.class);

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Role findByID(String roleID) {
        return roleRepository.findById(roleID).get();
    }
}