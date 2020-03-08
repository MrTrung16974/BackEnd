package com.vnp.template.service;

import com.vnp.template.model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRole();
    public Role findByID(Integer roleID);
}
