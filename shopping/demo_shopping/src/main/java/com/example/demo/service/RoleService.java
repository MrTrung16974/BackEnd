package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRole();
    public Role findByID(Integer roleID);
}
