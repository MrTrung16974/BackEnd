package com.example.actorserviceapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActorController {

    @RequestMapping("/web/home")
    public String pageHome() {
        return "web/index";
    }

    @RequestMapping("/web/detail")
    public String pageDetailWeb() {
        return "web/detail";
    }


    @RequestMapping("/admin/home")
    public String pageHomeAdmin() {
        return "admin/index";
    }
}
