package com.example.websocket.chatting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HttpExceptionController {

    @ExceptionHandler(Throwable.class)
    @GetMapping("/error")
    public String handleHttpError() {
        log.debug("에러 페이지");
        return "에러 페이지";
    }
}
