package com.example.springsecurity.controller;

import com.example.springsecurity.model.User;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/order")
    public String vip(){
        return "order";
    }
    @RequestMapping("/403")
    public String notPo(){
        return "403";
    }
    @RequestMapping("/catalog")
    public String catalog(){
        return "catalog";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String findProductByCategory(@RequestParam("type") Integer type) {
        return "redirect:/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String AddUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("name") String name) {
        User user = new User();
        user.setId(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Arrays.asList("ADMIN", "USER", "VIP"));
        userRepository.save(user);
        return "redirect:/login?regisSuccess=true";
    }
}