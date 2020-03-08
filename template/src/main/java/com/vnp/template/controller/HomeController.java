package com.vnp.template.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping({"/home","/"})
    public String home(){
        return "home";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }
    @RequestMapping("/icon")
    public String icon(){
        return "icon";
    }
    @RequestMapping("/map")
    public String map(){
        return "map";
    }
    @RequestMapping("/table")
    public String table(){
        return "table";
    }
    @RequestMapping("/notification")
    public String notification(){
        return "notification";
    }
    @RequestMapping("/typography")
    public String typography(){
        return "typography";
    }
    @RequestMapping("/upgrade")
    public String upgrade(){
        return "upgrade";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
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
