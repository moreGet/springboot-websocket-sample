package com.example.websocket.chatting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestController
public class HttpExceptionController {

    @GetMapping("/error")
    public String handleRuntimeError() {
        return "HTTP EXCEPTION ";
    }
}
