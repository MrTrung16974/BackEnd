package com.example.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {
    @Autowired
    SimpMessageSendingOperations messageSendingOperations;

    @RequestMapping("/start")
    public String start() {
        return "start";
    }

    @RequestMapping("/message")
    @ResponseBody
    public String chat() {
        this.messageSendingOperations.convertAndSend("/topic/notification", "TEST");
        return "OK";
    }


}
