package com.example.backendkyc.controller;

import com.example.backendkyc.reposiroty.UserRepository;
import com.example.backendkyc.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping({"/","/home"})
    public String home(Model model){
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    @PreAuthorize("isAuthenticated()")
    public String welcome(HttpServletRequest request, HttpSession session) {
        return "welcome";
    }

    @RequestMapping("/403")
    public String noPermission() {
        return "403";
    }

    @RequestMapping("/404")
    public String notFound() {
        return "404";
    }

    @RequestMapping("/500")
    public String internalError() {
        return "500";
    }


}
