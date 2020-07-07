package com.example.backendkyc.service;

import com.example.backendkyc.model.User;
import com.example.backendkyc.utils.Constant;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    final static Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private static final Gson gson = new Gson();

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        LOGGER.debug("Find User by Name: {}", userName);
        User user = userService.getUserByUserName(userName);
        if (user == null) {
            LOGGER.debug("{} not found!", userName);
            throw new UsernameNotFoundException("Tài khoản :" + userName + " không tồn tại !");
        }
        String roleID = user.getRoleID();
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleID != null) {
            roleService.findByID(roleID).getFunctions().stream().map((function) -> new SimpleGrantedAuthority(function.getId())).forEachOrdered((authority) -> {
                grantList.add(authority);
            });
            if(roleID.equals(Constant.ROLE_SUPER_ID)){
                grantList.add(new SimpleGrantedAuthority(roleService.findByID(roleID).getRoleCode()));
            }
        }
        LOGGER.debug("{}: grantList: {}", userName, gson.toJson(grantList));
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), user.getStatus() == 1, user.getStatus() != 2, user.getStatus() != 2, user.getStatus() != 3, grantList);
        return userDetails;
    }
}