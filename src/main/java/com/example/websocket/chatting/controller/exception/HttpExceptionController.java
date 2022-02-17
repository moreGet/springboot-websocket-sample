package com.example.websocket.chatting.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HttpExceptionController implements ErrorController {

    @GetMapping("/error")
    public String handleHttpException() {
        return "HTTP EXCEPTION ";
    }
}